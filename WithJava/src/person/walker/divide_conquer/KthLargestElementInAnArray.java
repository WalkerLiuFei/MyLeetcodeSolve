package person.walker.divide_conquer;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        divide(nums,k,0,nums.length-1);
        return 0;
    }
    private void divide(int[] nums, int kLargest, int low, int high) {
        if (low >= high)
            return;
        //if (high == low)
            //return nums[low];
        int key = nums[low];
        int i = low;
        int j = high ;
        while (true){
            while (nums[i] <= key && i < j) i++;
            while (nums[j] > key && j > i) j--;
            if (i >= j)
                break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[low] = nums[i];
        nums[i] = key;
        divide(nums,kLargest,i+1,high);
        divide(nums,kLargest,low,i-1);
    }
    @Test
    public void test(){
        int[] array = new int[10];
        for (int index = 0; index < 10;index++){
            array[index] = (int) (Math.random() * 100 +1);
        }
        new KthLargestElementInAnArray().findKthLargest(array,1);
        for (int index = 0; index < 10;index++){
            System.out.print(array[index] +" ");
        }

    }
}
