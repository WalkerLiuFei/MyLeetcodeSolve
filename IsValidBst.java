package com.company;

import com.sun.corba.se.pept.transport.InboundConnectionCache;
import org.omg.CORBA.NO_IMPLEMENT;

/**
 * Created by Administrator on 2016/7/31 0031.
 */

//beat 33.15%.....
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class IsValidBst {
        public boolean isValidBST(TreeNode root) {
            if (root == null)
                return true;
            return isSubValid(root,null,null );
        }
        public boolean isSubValid(TreeNode node,Integer maxValue,Integer minValue){
            if (node == null )
                    return true;
            if (node.left == null || (node.val > node.left.val && (minValue == null|| node.left.val > minValue  ))
                                            && (node.right == null || (node.val < node.right.val && (maxValue == null  || node.right.val < maxValue ))))
                return (isSubValid(node.left,node.val,minValue) && isSubValid(node.right,maxValue,node.val));
            return false;
        }
}