package person.walker.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length()< 1)
            return result;
        List<String> currentList = new ArrayList<>();
        dfs(s,currentList,1,result);
        return result;
    }

    private void dfs(String s, List<String> currentList, int currentIndex, List<List<String>> result) {
        for (int index = currentIndex; index <= s.length();index++){
            String sub = s.substring(currentIndex-1,index);
            if(checkPartition(sub,currentList)){
                dfs(s,currentList, index+1, result);
                if (index == s.length())
                    result.add(new ArrayList<>(currentList));
                currentList.remove(currentList.size()-1);
            }
        }
    }

    private boolean checkPartition(String sub, List<String> result) {
        if (sub.length() == 1){
            result.add(sub);
            return true;
        }
        for (int front = 0,back = sub.length()-1; back > front; back-- ,front++){
            if (sub.charAt(front) == sub.charAt(back))
                continue;
            else
                return false;
        }
        result.add(sub);
        return true;
    }
    public static void main(String[] args){
        new PalindromePartitioning().partition("aabb");
    }
}
