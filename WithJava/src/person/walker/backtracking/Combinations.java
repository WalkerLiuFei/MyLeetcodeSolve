package person.walker.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] marked = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        dfs(n,k,list,1,result,marked);
        return result;
    }
    private void dfs(int n,int targetLength, List<Integer> list, int currentIndex ,List<List<Integer>> result, boolean[] marked) {
        if (list.size() == targetLength){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int index = currentIndex; index <= n; index ++){
            if (marked[index])
                continue;
            list.add(index);
            marked[index] = true;
            dfs(n,targetLength,list,currentIndex+1 ,result,marked);
            list.remove(list.size()-1);
            marked[index] = false;
        }
    }
}
