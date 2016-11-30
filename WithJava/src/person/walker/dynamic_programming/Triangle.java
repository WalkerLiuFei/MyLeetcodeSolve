package person.walker.dynamic_programming;

import java.util.List;

/**
 * beat 45.3 %......
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];//最多只会有这么多可能性

        //利用最后一行的元素去初始化dp
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int index = dp.length - 1; index > 0; index--) {
            dp[index] = lastRow.get(index);
        }
        for (int level = triangle.size() - 2; level > 0; level--) { //自下而上的遍历
            List<Integer> listElements = triangle.get(level);
            for (int index = 0; index < listElements.size(); index--) {
                int currentElement = listElements.get(index);
                dp[index] = Math.min(dp[index] + currentElement, dp[index + 1] + currentElement); //通往当前元素的两个可能值，并取最小的那个
            }
        }
        return dp[0];
    }
}
