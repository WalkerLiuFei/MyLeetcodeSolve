package person.walker.tree;

import person.walker.TreeNode;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenLeaf(root);
    }

    private TreeNode flattenLeaf(TreeNode node) {
        if (node.left == null && node.right == null) //find the leaf and return
            return node;

        return node;

    }
}
