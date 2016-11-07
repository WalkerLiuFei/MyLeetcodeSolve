package person.walker;

import com.company.algorithm.BinarySearchTree;
import com.company.algorithm.Node;

/**
 * Created by Administrator on 2016/7/18 0018.
 */
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.setRootNode(nums[0],0);
        for (int index = 1; index < nums.length; index ++)
            binarySearchTree.put(nums[index],index);
        return true;
    }
}
