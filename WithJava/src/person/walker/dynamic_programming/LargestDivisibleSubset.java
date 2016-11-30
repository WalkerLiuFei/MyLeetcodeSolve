package person.walker.dynamic_programming;

import java.util.*;

/**
 * number 368.. beat 68.64%....refer other people's solution
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        int[] T = new int[nums.length];
        int[] parent = new int[nums.length];
        int m = 0;
        int mi = 0;
        for (int i = nums.length - 1; i >= 0;i--){
            for (int j = i; j < nums.length;++j){
                if(nums[j] % nums[i] == 0 && T[i] < T[j] +1){
                    T[i] = 1+ T[j];
                    parent[i] = j;
                    if (T[i] > m){
                        m = T[i];
                        mi = i;
                    }
                }
            }
        }
        List max = new ArrayList<>();
        for (int i = 0;i < m; ++i){
            max.add(nums[mi]);
            mi = parent[mi];
        }
        return max;
    }
}
