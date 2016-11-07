package person.walker;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/29 0029.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxSofar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i],maxEndingHere+nums[i]);
            maxSofar = Math.max(maxSofar,maxEndingHere);
        }
        return maxSofar;
    }
}
