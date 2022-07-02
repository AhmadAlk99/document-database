package Indexes;


import java.util.*;


public class mappedIndexed <K, V>{

    private HashMap<K, List <V>>map=new HashMap<>();
    private List<V> list;

    public void put(K key,V value){
        if(map.containsKey(key)){
            list =map.get(key);
            list.add(value);
            map.put(key, list);
        }
        else{
            list =new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    public List<V> get(K key){
        List<V> values = new ArrayList<>();
        if(key==null)return values;

        values=map.get(key);
        return values;
    }

}
/*
tree<String,String> tre=new tree<>();
        tre.put("ahmad","first");
        tre.put("ahmad","second");
        tre.put("mohammed","first");
        tre.put("husien","second");
        List<String>lists=tre.get("ahmad");
        for (String s : lists) {
            System.out.println(s);
        }*/