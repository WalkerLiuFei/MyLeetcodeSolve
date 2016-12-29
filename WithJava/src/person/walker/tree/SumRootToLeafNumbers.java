package person.walker.tree;

import person.walker.TreeNode;

import java.math.BigInteger;

/**
 * Created by Administrator on 2016/12/8 0008.
 */
public class SumRootToLeafNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode node, int current) {
        if (node == null)
            return;
        current =  current * 10 + node.val;
        if (node.right == null && node.left == null) { //find the leaf and add to the sum
            sum += current;
            return;
        }
        helper(node.left, current);
        helper(node.right, current);
    }
}
