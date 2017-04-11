package person.walker.string;

import org.junit.Test;

/**
 * Created by Administrator on 2017/4/1 0001.
 */
public class ReverseWordsInString {
    @Test
    public void test(){
        System.out.println(reverseWords( "wod      hi!"));
    }
    public String reverseWords(String s) {
        if (s.length() <= 1)
            return s.trim();
        String result = new String();
        String[] words = s.split(" ");
        for (int back = words.length-1; back >= 0 ;back --){
            String word = words[back];
            if (word.isEmpty()){
                continue;
            }
            result = result.concat(word+" ");
        }
        return result.trim();
    }
}
