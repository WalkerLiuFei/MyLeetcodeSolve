package person.walker.dfs;

import person.walker.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2016/11/17 0017.
 */
public class BinaryTreeRightSideView {
    //我在这用了 bfs,其实用dfs时间复杂度更低！！
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> viewIntegers = new ArrayList<>();
        if (root == null)
            return viewIntegers;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            while (levelNum-- > 1){
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                queue.poll();
            }
            if (queue.peek().left != null) queue.offer(queue.peek().left);
            if (queue.peek().right != null) queue.offer(queue.peek().right);
            viewIntegers.add(queue.poll().val);
        }
        return viewIntegers;
    }

}
