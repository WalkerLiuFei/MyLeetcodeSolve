package person.walker;

/**
 * Created by Administrator on 2016/11/13 0013.
 */
public class TreeNode {
    public  int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public TreeNode(int x) {
        val = x;
    }
}
