package Iterview;

import java.util.*;

public class OcurrencesDescTreeMap {
    public static int[] ocurrencesDescSort(int[] array){
        Map<Integer,Integer> ocurrencesMap = new HashMap(array.length);

        for(int i = 0; i < array.length; i++) {
            if (!ocurrencesMap.containsKey(array[i])){
                ocurrencesMap.put(array[i],1);
            }else {
                ocurrencesMap.put(array[i], ocurrencesMap.get(array[i]) +1);
            }
        }

        Map<Integer, List<Integer>> reverseSortedMap = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());

        for(Integer key: ocurrencesMap.keySet()) {
            int val = ocurrencesMap.get(key);
            if(!reverseSortedMap.containsKey(val)){
                reverseSortedMap.put(val, new ArrayList<Integer>(){{add(key);}});
            }else{
                reverseSortedMap.get(val).add(key);
            }
        }

        reverseSortedMap.values().stream().parallel().filter(l -> l.size() > 1).sorted();



        int[] newArray = new int[array.length];
        int index = 0;

        for (Integer ocurrences: reverseSortedMap.keySet()) {
            for (Integer val: reverseSortedMap.get(ocurrences)) {
                for (int j = index; j < (index + ocurrences) ; j++) {
                    newArray[j] = val;
                }
                index += ocurrences;
            }
        }

        return newArray;
    }
}
