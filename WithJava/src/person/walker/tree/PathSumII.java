package person.walker.tree;

import org.junit.Test;
import person.walker.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        dfs(result, root, root.val, list, sum);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode node, int currentSum, List<Integer> list, int target) {
        if (currentSum == target && node.left == null && node.right == null) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (null != node.left) {
            list.add(node.left.val);
            dfs(result, node.left, currentSum + node.left.val, list, target);
            list.remove(list.size() - 1);
        }
        if (null != node.right) {
            list.add(node.right.val);
            dfs(result, node.right, currentSum + node.right.val, list, target);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        new PathSumII().pathSum(root, -1);
    }
}
