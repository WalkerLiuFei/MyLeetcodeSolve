package com.company;

import java.util.*;

/**
 * 没有完成，自学完DP 算法后再来做！
 */
public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, int[]> characterMap = new HashMap<Character, int[]>();
        int srcMax = 1;
        Character maxDiffChar = s.charAt(0);
        for (int count = 0; count < s.length(); count++) {
            Character character = s.charAt(count);
            if (!characterMap.containsKey(character)) {
                int[] indexArray = new int[2];
                indexArray[0] = count;
                characterMap.put(character, indexArray);
            } else {
                int[] indexArray = characterMap.get(character);
                if (indexArray.length > 1){                 //获取
                    if((count - indexArray[1]) > (indexArray[1] - indexArray[0]))
                        indexArray[1] = count;
                    int diff = indexArray[1] - indexArray[0];
                    if (diff > srcMax){
                        srcMax = diff;
                        maxDiffChar = s.charAt(count);
                    }
                }
            }
        }
        Collection<int[]> valueSet = characterMap.values();
        Iterator iterator = valueSet.iterator();
        int maxLength = 1;
        int[] compareArray = characterMap.get(maxDiffChar);
        while (iterator.hasNext()) {
            int[] indexArray = (int[]) iterator.next();
            if (indexArray[1] < compareArray[1] && indexArray[0] > compareArray[0]) // 如果这个
            if (indexArray == null)
                continue;

        }
        return maxLength;
    }
}
