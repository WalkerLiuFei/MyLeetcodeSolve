package person.walker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class LongestSubstringWithoutRepeatingCharacters {
  /*      public int lengthOfLongestSubstring2(String s){
        int[] allChar = new int[256];
          int longest = , m = 0;
          for (int i = 0; i < s.length(); i++) {
              char ch = s.charAt(i);
              m = Math.max(allChar[ch] + 1, m);    // automatically takes care of -1 case
              allChar[ch] = i;
              longest = Math.max(longest, i - m + 1);
          }
        return longest;
      }*/



    public int lengthOfLongestSubstring(String s) {
            if (s.length() ==0)
                return 0;
            char[] chars = s.toCharArray();
            int startPointer = 0; //起始位置就是0,第一个存入map的subString的起始位置
            int endPointer = chars.length;
            //List<String> subStrings = new ArrayList<>();
            int max = 1;
            for (int pointer1 = 0;pointer1 <= chars.length; pointer1++){
                if (endPointer == pointer1){
                    if (endPointer - startPointer > max)
                        max = endPointer - startPointer;
                    //subStrings.add(new String(Arrays.copyOfRange(chars,startPointer,endPointer+1)));
                    startPointer = pointer1;
                    endPointer =  chars.length;
                }
                for (int pointer2 = pointer1+1; pointer2 < endPointer;pointer2++){

                    if (chars[pointer1] == chars[pointer2]){ //查到相同的元素
                        endPointer = pointer2;
                        break;
                    }
                }
            }
            return max;
        }
    public static void main(String [] args){
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf" +
                ""));
    }
}
