package person.walker.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] marked = new boolean[10];
        dfs(k,n,result,list,0,marked,1);
        return result;
    }

    private void dfs(int lengthRestrict, int target, ArrayList<List<Integer>> result, ArrayList<Integer> list, int currentSum, boolean[] marked,int currentIndex) {
        if (list.size() == lengthRestrict){
            if (currentSum == target)
                result.add(new ArrayList<>(list));
            return;
        }
        for (int index = currentIndex;index < 10;index++){
            if (marked[index])
                continue;
            list.add(index);
            marked[index] = true;
            dfs(lengthRestrict,target,result,list,currentSum+index,marked,index+1);
            list.remove(list.size()-1);
            marked[index] = false;
        }
    }
}
