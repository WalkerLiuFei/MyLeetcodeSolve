package person.walker.backtracking;

import java.util.*;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length < 1)
            return null;
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursive(result, temp, candidates, target, 0);
        return result;
    }

    private void recursive(List<List<Integer>> result, List<Integer> list, int[] candidates, int currentValue, int currentIndex) {
        if (currentValue == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (currentValue < 0)
            return;
        for (int index = currentIndex ; index < candidates.length; index++) {
             if (index > 1 && candidates[index] == candidates[index-1])
                continue;
            list.add(candidates[currentIndex]);
            recursive(result,list,candidates,currentValue-candidates[index],currentIndex+1);
            list.remove(list.size()-1);
        }
    }
}
