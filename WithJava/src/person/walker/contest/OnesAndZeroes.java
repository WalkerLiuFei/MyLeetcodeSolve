package person.walker.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 先看是 0 多，还是1度
 */
public class OnesAndZeroes {
    int max;
    public int findMaxForm(String[] strs, int m, int n) {
       // List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int index = 0; index < strs.length ;index ++){
            List<String> list1 = new ArrayList<>();
            helper(strs,m,n,0,list);
        }

       return max;
    }

    private void helper(String[] strs, int m, int n, int currentIndex, List<String> list) {
        if (m < 0 || n < 0)
            return;
        else {
            max = Math.max(max,list.size()-1);
        }
        if (currentIndex >= strs.length)
            return;

        int useZero = 0;
        String s = strs[currentIndex];
        for (int index = currentIndex; index < strs.length;index++){
            for (char c : s.toCharArray()){
                if (c == '0')
                    useZero += 1;
            }
            list.add(s);
            int zeroLeft = m - useZero;
            int oneLeft = n-(s.length() - useZero);
            helper(strs,zeroLeft,oneLeft,currentIndex+1, list);
            list.remove(list.size() -1);
        }
    }
    @Test
    public void test(){
        new OnesAndZeroes().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3);
    }
}
