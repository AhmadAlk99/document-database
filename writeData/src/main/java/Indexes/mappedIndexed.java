package Indexes;


import java.util.*;


public class mappedIndexed<K, V>{

    private HashMap<K, List <V>> mapOfIndex =new HashMap<>();
    private List<V> list;

    public void put(K key,V value){
        if(mapOfIndex.containsKey(key)){
            list = mapOfIndex.get(key);
            list.add(value);
            mapOfIndex.put(key, list);
        }
        else{
            list =new ArrayList<>();
            list.add(value);
            mapOfIndex.put(key, list);
        }
    }
    public List<V> get(K key){
        List<V> values = new ArrayList<>();
        if(key==null)return values;

        values= mapOfIndex.get(key);
        return values;
    }

}