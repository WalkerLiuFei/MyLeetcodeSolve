package com.company.algorithm;

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList list = new ArrayList();
        if (listNode == null)
            return list;
        while (listNode != null){
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for (int count = 1;count < sum/2-1; count++){
            Double countEnd;
            countEnd = Math.sqrt(2*sum + count*count);
            int countEndInt = countEnd.intValue();
            if (countEnd == countEndInt){
                if (countEndInt % count != 0)
                    break;
                ArrayList<Integer> result = new ArrayList<Integer>();
                while (countEndInt >= count)
                    result.add(countEndInt--);
                results.add(result);
                continue;
            }else{
                
            }
            //countEnd = Math.sqrt()
        }
        return results;
    }
}
