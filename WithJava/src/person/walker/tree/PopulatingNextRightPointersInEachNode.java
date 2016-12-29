package person.walker.tree;

import org.junit.Test;
import person.walker.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 和层次遍历如出一辙
 */

class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()){
            int levelNodeNum = nodes.size();
            while (levelNodeNum-- > 0){
                TreeLinkNode node =  nodes.peek();
                if (node.left != null)
                    nodes.offer(node.left);
                if (node.right != null)
                    nodes.offer(node.right);
                nodes.poll();
                node.next = levelNodeNum > 0 ? nodes.peek() : null;
            }
        }
    }

    @Test
    public  void test(){
        TreeLinkNode node = new TreeLinkNode(0);
        node.left = new TreeLinkNode(1);
        node.right= new TreeLinkNode(2);
        node.left.left = new TreeLinkNode(3);
        node.left.right= new TreeLinkNode(4);

        node.right.left = new TreeLinkNode(5);
        node.right.right = new TreeLinkNode(6);
        new PopulatingNextRightPointersInEachNode().connect(node);
    }
}
