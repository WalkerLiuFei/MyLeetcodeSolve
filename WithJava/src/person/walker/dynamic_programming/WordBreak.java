package person.walker.dynamic_programming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public class WordBreak {
    @Test
    public void test(){
        System.out.println("1.0.1.1".compareTo("1.1"));
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        list.add("goo");
        list.add("go");
        System.out.println(wordBreak("leetcodegood",list));
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int front = 1;front <= s.length();front++){
            for (int back = 0;back < front;back++){
                if ( dp[back] && wordDict.contains(s.substring(back,front))){
                    dp[front] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
