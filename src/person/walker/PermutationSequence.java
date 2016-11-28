package person.walker;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class PermutationSequence {
    private int appenedCount = 1;
    public String getPermutation(int n, int k) {
        int[] result = new int[n];
        boolean[] marked = new boolean[n+1];
        return  dfs(n,k,result,0,marked);
    }

    private String dfs(int n, int targetIndex, int[] nums, int currentLength, boolean[] marked) {
        if (currentLength == n){
            if (appenedCount == targetIndex)
                return toString(nums);
            else
                appenedCount +=  1;
                return null;
        }
        for (int index = 1; index <= n; index ++){
            if (marked[index])
                continue;
            nums[currentLength] = index;
            marked[index] = true;
            String result = dfs(n,targetIndex,nums,currentLength + 1,marked);
            if (result != null)
                return result;
            marked[index] = false;
        }
        return null;
    }
    public static String toString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.toString();
        }
    }
    public static void main(String[] args){
        new PermutationSequence().getPermutation(4,2);
    }
}
