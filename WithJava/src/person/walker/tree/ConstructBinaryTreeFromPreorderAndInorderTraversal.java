package person.walker.tree;

import org.junit.Test;
import person.walker.TreeNode;

import java.util.Arrays;

/**
 * there must be a better way to solve this problem!
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int preorderIndex = -1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length < 1)
            return null;
        TreeNode result = dfs(preorder,inorder);
        return result;
    }


    private TreeNode dfs(int[] preorder,int[] nodeValues) {
        if (nodeValues.length < 1)
            return null;
        preorderIndex++;
        if (nodeValues.length == 1)
            return new TreeNode(nodeValues[0]);
        int nodeValuesIndex = 0;
        //find the root value
        while ( nodeValuesIndex < nodeValues.length && nodeValues[nodeValuesIndex] != preorder[preorderIndex] ) nodeValuesIndex++;

        TreeNode node = new TreeNode(nodeValues[nodeValuesIndex]);
        //left nodes' value!
        node.left = dfs(preorder,Arrays.copyOfRange(nodeValues,0,nodeValuesIndex));
        //right node's value!
        node.right = dfs(preorder,Arrays.copyOfRange(nodeValues,nodeValuesIndex+1,nodeValues.length));
        return node;
    }

}
