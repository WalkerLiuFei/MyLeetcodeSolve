package person.walker;

import java.util.*;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
public class GenerateParentheses {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTracking(2*n,n,1,0,1,"("); //长度为2*nde 字符串满足条件！
        return result;
        /*
          思路：
          1:利用indicateFlag 标示是否添加 右括号。左括号添加一次加一，右括号添加一次减一。不能为 负数！
          2:构建一个char[2n-1] 的状态空间。每次都去尝试左括号和右括号。不满足的话就回到上一次的状态。
            其实想层次遍历二叉树一样。利用BFS！队列
         3 : 假设左子 为右半括号，右子为左半括号
         */
        /*Queue queue = new LinkedList();
        queue.offer(result);
        int indicateFlag = 1; // could not be negative!
        while (!queue.isEmpty()){
            int levelNum  = queue.size();
            if (is)     //利用level num 将全部可能行的括号添加进去

        }*/
    }

    private void backTracking(int resLength,int paraNum, int leftAdded,int rightAdded,int flag, String cont) {
        System.out.println(cont);
        if (flag < 0 || rightAdded > paraNum || leftAdded > paraNum)
            return;
        if (cont.length() == resLength){
            result.add(cont);
        }
        if (flag > 0)
            backTracking(resLength,paraNum,leftAdded,rightAdded+1,flag-1,cont+")");

        if (flag >=0)
            backTracking(resLength,paraNum,leftAdded+1,rightAdded,flag+1,cont+"(");
    }
    public static void main(String args[]){
        new GenerateParentheses().generateParenthesis(3);
    }
}
