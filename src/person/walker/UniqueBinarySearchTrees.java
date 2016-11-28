package person.walker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * beat 51.84%!!!!!! nice solution!(*^__^*) 嘻嘻……
 */

public class UniqueBinarySearchTrees {

    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> allNodes = new ArrayList<TreeNode>();
        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];

        dp[0] = new ArrayList<>();
        dp[0].add(null);
        if (n == 0)
            return dp[0];
        //init node when the root is 1
        TreeNode node_1 = new TreeNode(1);
        ArrayList<TreeNode> treeNodes_1 = new ArrayList<>();
        treeNodes_1.add(node_1);
        dp[1] = treeNodes_1;

        for (int level = 2;level <= n ; level++){ //dp 每个点的List集合
            dp[level] = new ArrayList<>();
            for (int rootNodeValue = 1; rootNodeValue <= level; rootNodeValue++) {
                for (TreeNode leftNode : dp[rootNodeValue-1]){  //遍历左子树可能会出现的值并插入到 根树的左子树
                    TreeNode treeNode = new TreeNode(rootNodeValue); //为这个点建立一个TreeNode
                    treeNode.left = leftNode;
                    for (TreeNode rightNode : dp[level - rootNodeValue]){ //遍历右子树可能会出现的值并插入到 根树的右子树
                        TreeNode node = new TreeNode(rootNodeValue); //为这个点建立一个TreeNode
                        node.left = treeNode.left;
                        node.right = changValue(rightNode,rootNodeValue); //右子树的值肯定比rootNodeValue 大，并且是大的值为rootNodeValue
                        dp[level].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode changValue(TreeNode sourceNode, int value) {
        if (sourceNode == null)
            return sourceNode;
        TreeNode newNode = new TreeNode(sourceNode.val);
        newNode.val += value;
        if (sourceNode.right != null)
            newNode.right = changValue(sourceNode.right, value);
        if (sourceNode.left != null)
            newNode.left = changValue(sourceNode.left, value);
        return newNode;
    }


    /**
     * First note that dp[k] represents the number of BST trees built from 1....k;
     * <p>
     * Then assume we have the number of the first 4 trees: dp[1] = 1 ,dp[2] =2 ,dp[3] = 5, dp[4] =14 , how do we get dp[5] based on these four numbers is the core problem here.
     * <p>
     * The essential process is: to build a tree, we need to pick a root node, then we need to know how many possible left sub trees and right sub trees can be held under that node, finally multiply them.
     * <p>
     * To build a tree contains {1,2,3,4,5}. First we pick 1 as root, for the left sub tree, there are none; for the right sub tree, we need count how many possible trees are there constructed from {2,3,4,5}, apparently it's the same number as {1,2,3,4}. So the total number of trees under "1" picked as root is dp[0] * dp[4] = 14. (assume dp[0] =1). Similarly, root 2 has dp[1]*dp[3] = 5 trees. root 3 has dp[2]*dp[2] = 4, root 4 has dp[3]*dp[1]= 5 and root 5 has dp[0]*dp[4] = 14. Finally sum the up and it's done.
     * <p>
     * Now, we may have a better understanding of the dp[k], which essentially represents the number of BST trees with k consecutive nodes. It is used as database when we need to know how many left sub trees are possible for k nodes when picking (k+1) as root.
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int root = 2; root <= n; root++)
            for (int level = 1; level <= root; level++)
                dp[root] += dp[level - 1] * dp[root - level];
        return dp[n];
    }

    public static void main(String[] args) {
        ArrayList list = (ArrayList) new UniqueBinarySearchTrees().generateTrees(3);
        System.out.println(list.size());
    }
}
