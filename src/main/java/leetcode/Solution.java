package leetcode;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;


public class Solution {

    public static void main(String[] args) {
        String[] titles = getMovieTitles("lion");
        for (String title: titles) {
            System.out.println(title);
        }
    }

    public class JsonResult {

        @SerializedName("page")
        public String page;

        @SerializedName("per_page")
        public int per_page;

        @SerializedName("total")
        public int total;

        @SerializedName("total_pages")
        public int total_pages;

        @SerializedName("data")
        public Title[] titles;
    }

    public class Title {

        @SerializedName("Poster")
        public String poster;

        @SerializedName("Title")
        public String title;

        @SerializedName("Type")
        public String type;

        @SerializedName("Year")
        public int year;

        @SerializedName("imdbID")
        public String imdbId;

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getImdbId() {
            return imdbId;
        }

        public void setImdbId(String imdbId) {
            this.imdbId = imdbId;
        }


    }

    static String[] getMovieTitles(String substr) {

        InputStream is = null;
        JsonResult result = null;
        String[] generatedTitleList = null;

        try{
            int index = 0;
            boolean gotSize = false;
            int size = 1;
            for(int i = 0; i < size; i++){
                String urlString = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + (i + 1);
                URL url = new URL(urlString);
                URLConnection conn = url.openConnection();
                is = conn.getInputStream();
                Reader reader = new InputStreamReader(is, "UTF-8");
                result  = new Gson().fromJson(reader, JsonResult.class);
                if(!gotSize){
                    generatedTitleList = new String[result.total];
                    gotSize = true;
                    size = result.total_pages;
                }
                generateTitleList(generatedTitleList, result.titles, index);
                index+=result.per_page;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(is != null){
                try{
                    is.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }

            }
        }

        Arrays.sort(generatedTitleList);
        return generatedTitleList;

    }

    private static void generateTitleList(String[] generatedTitleList, Title[] titles, int index) {

        for(int i = 0; i < titles.length; i++){
            generatedTitleList[index] = titles[i].title;
            index++;
        }

    }
}
