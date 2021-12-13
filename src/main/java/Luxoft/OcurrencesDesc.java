package Luxoft;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class OcurrencesDesc {

    public static int[] ocurrencesDescSort(int[] array){
        Map<Integer,Integer> ocurrencesMap = new HashMap(array.length);

        for(int i = 0; i < array.length; i++) {
                if (!ocurrencesMap.containsKey(array[i])){
                    ocurrencesMap.put(array[i],1);
                }else {
                    ocurrencesMap.put(array[i], ocurrencesMap.get(array[i]) +1);
                }
        }

        Map<Integer, List<Integer>> map= new HashMap<>();

        for(Integer key: ocurrencesMap.keySet()) {
            int val = ocurrencesMap.get(key);
            if(!map.containsKey(val)){
              map.put(val, new ArrayList<Integer>(){{add(key);}});
            }else{
                map.get(val).add(key);
            }
        }

        map.values().stream().parallel().filter(l -> l.size() > 1).sorted();

        List<Integer> sortedValues = map.keySet().parallelStream().collect(Collectors.toList());
        Collections.sort(sortedValues,Collections.reverseOrder());

        int[] newArray = new int[array.length];
        int index = 0;

        for (Integer ocurrences: sortedValues) {
            for (Integer val: map.get(ocurrences)) {
                for (int j = index; j < (index +ocurrences) ; j++) {
                    newArray[j] = val;
                }
                index += ocurrences;
            }
        }

        return newArray;
    }

}
