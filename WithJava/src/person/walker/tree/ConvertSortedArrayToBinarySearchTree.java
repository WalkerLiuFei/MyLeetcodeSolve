package person.walker.tree;

import person.walker.TreeNode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1)
            return null;
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums,int left,int right) {
        if (left > right)
            return null;
        int mid = (right + left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,left,mid-1);
        node.right = helper(nums,mid+1,right);
        return node;
    }
}
