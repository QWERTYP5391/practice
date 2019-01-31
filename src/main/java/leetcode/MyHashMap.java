package leetcode;

import java.util.LinkedList;

public class MyHashMap {

    private static int size = 10;
    LinkedList<MyNode>[] listOfBuckets = new LinkedList[size];


    public Object get(String key) {

        int index = Math.abs(key.hashCode() % size);
        LinkedList<MyNode> bucket = listOfBuckets[index];

        if (bucket.size() == 0) {

        } else if (bucket.size() == 1) {
            return bucket.getFirst().value;
        } else {
            for (int i = 0; i < bucket.size(); i++) {
                MyNode node = bucket.get(i);
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }

        return null;
    }

    public void put(Object key, Object value){
        int index = Math.abs(key.hashCode() % size);
        LinkedList<MyNode> linkedList = listOfBuckets[index];
        if(linkedList == null){
            LinkedList<MyNode> insertedNode = new LinkedList<MyNode>();
            insertedNode.add(new MyNode(key, value));
            listOfBuckets[index] = insertedNode;
        }
        else {

        }
    }

    public void resize(){

    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put("Ebrima", 10);
        Object result = myHashMap.get("Ebrima");
        myHashMap.put("Saturday", 12);
        System.out.println(result);
        System.out.println(myHashMap.get("Saturday"));
    }


}
