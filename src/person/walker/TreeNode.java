package person.walker;

/**
 * Created by Administrator on 2016/11/13 0013.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    TreeNode(int x) {
        val = x;
    }
}
