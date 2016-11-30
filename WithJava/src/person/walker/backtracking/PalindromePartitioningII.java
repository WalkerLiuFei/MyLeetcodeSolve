package person.walker.backtracking;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s.length() < 2)
            return 0;
        int[] cutCount = new int[s.length()];
        cutCount[0] = 0;
        cutCount[1] = s.charAt(1) == s.charAt(0) ? 0 : 1;
        int checkPoint = 0; //选择一个变量记录下一个index 要对比的位置
        int index = 2;

        for(;index < s.length(); index++ ){
            if(checkPoint >=0 && s.charAt(index) == s.charAt(index-1)){
                cutCount[index] = cutCount[index-1];
                checkPoint = index-2;
                continue;
            }
            if (s.charAt(index) == s.charAt(index-2)){
                cutCount[index] = cutCount[index-2];
                checkPoint = index-3;
                continue;
            }


            if (checkPoint >= 0 && s.charAt(index) == s.charAt(checkPoint)){
                if (checkPoint < index -1)
                checkPoint =  checkPoint -1;cutCount[index] = cutCount[index-1] - 1;
            }else {
                cutCount[index] = cutCount[index-1] + 1;
                checkPoint = index;
            }
        }
        return cutCount[s.length()-1];
    }
    public static  void main(String[] args){
        new PalindromePartitioningII().minCut("cbbbcc");
    }
}
