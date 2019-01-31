package leetcode;

import java.util.*;

public class InRhythm {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 1, 1, 3, 5, 2, 2);
        List<Integer> answer = compute(list);
        System.out.println(answer);
        System.out.println(answer.equals(Arrays.asList(1, 1, 1, 1, 3, 3, 2)));

    }

    public static List<Integer> compute(List<Integer> list) {
        TreeSet<MyObject> set = new TreeSet<MyObject>();
        List<Integer> result = new ArrayList<Integer>();

        populate(list, set);
        generate(set, result);

        return result;
    }

    private static void generate(TreeSet<MyObject> set, List<Integer> result) {
        for (MyObject o : set) {
            int occurrences = o.occurrences;
            for (int i = 0; i < occurrences; i++) {
                result.add(o.key);
            }

        }
    }

    private static void populate(List<Integer> list, TreeSet<MyObject> set) {
        for (int i = 0; i < list.size(); i++) {
            Integer value = list.get(i);
            boolean foundKey = false;
            for (MyObject o : set) {
                if (o.key == value) {
                    int occurrences = o.occurrences + 1;
                    set.remove(o);
                    set.add(new MyObject(value, occurrences));
                    foundKey = true;
                    break;
                }
            }
            if (!foundKey) {
                set.add(new MyObject(value, 1));
            }

        }
    }
}


class MyObject implements Comparable<MyObject> {

    public Integer key;
    public Integer occurrences;

    MyObject(Integer key, Integer occurrences) {
        this.key = key;
        this.occurrences = occurrences;
    }


    public int compareTo(MyObject o) {

        int occurrences = o.occurrences.compareTo(this.occurrences);

        if (occurrences == 0) {
            return o.key.compareTo(this.key);
        } else {
            return occurrences;
        }

    }
}
