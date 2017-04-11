package person.walker.tree;

import person.walker.TreeNode;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/5 0005.
 */
public class ConstructBinaryTreeFromPostOrderAndInorderTraversal {
    public  TreeNode buildTree(int[] inorder , int[] postorder ) {
        if (inorder.length == 0 || postorder.length == 0){
            return null;
        }

        int lastIndex = postorder.length - 1;
        TreeNode root = new TreeNode(postorder[lastIndex]);
        if (lastIndex == 0){
            return root;
        }
        for (int index = 0; index < inorder.length; index++){
            if (inorder[index] == root.val){
                root.left = buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
                int startIndex = index +1;
                root.right = buildTree(Arrays.copyOfRange(inorder,startIndex,lastIndex+1),Arrays.copyOfRange(postorder,index,lastIndex));
                break;
            }
        }
        return root;
    }
}
