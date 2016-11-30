package person.walker.hash;

import java.util.*;

/**
 * number 347,  beat 30.71%
 */
public class KFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> kFrequent = new ArrayList<Integer>();
        HashMap<Integer, Integer> cacheMap = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (!cacheMap.containsKey(i)) {
                cacheMap.put(i, 1);
                continue;
            }
            int count = cacheMap.get(i) + 1;
            cacheMap.put(i, count);
        }
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(cacheMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int count = 0;
        while (count < k){
            kFrequent.add(list.get(count).getKey());
            count++;
        }
        return kFrequent;
    }
}