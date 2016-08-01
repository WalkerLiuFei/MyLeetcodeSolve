package com.company;

import com.company.algorithm.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class Example {

    String str = new String("good");

    char[] ch = {'a', 'b', 'c'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}

public class Main {
    public static void main(String[] args) {
    /*    ContainsNearbyAlmostDuplicate con = new ContainsNearbyAlmostDuplicate();

        con.containsNearbyAlmostDuplicate(new int[]{45,8,8,75,18,58,128,41},15,64);*/
/*        ArrayList<ArrayList<Integer>> results = Solution.FindContinuousSequence(100);
        for (ArrayList<Integer> arrayList : results){
            System.out.println(16*16 - 9*9);
            for (Integer integer : arrayList){
                System.out.print(integer+" ");
            }
        }*/
/*        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str3 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str3.intern() == str3);*/
        /*System.out.println(10_100);
        System.out.println(1000 & 1100);*/
        //System.out.println(new NumSquares().numSquares(12));
        //System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1,2,4,8,9,72}));
        //System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        //System.out.println(new MaxProfitI().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        //System.out.println(new UniquePaths().uniquePaths(3,3));
        //System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        //System.out.println(new MinimumPathSum().minPathSum(new int[][]{{0}}));
        System.out.println(new DecodeWays().numDecodings("1212"));
 /*       String str4 = new String("计算机软件");
        System.out.println(str4.intern() == str4);

        String str5 = new String("ja");
        System.out.println(str5.intern() == str5);

        String str2 = new StringBuilder("j").append("va").toString();
        System.out.println(str2.intern() == str2);*/

        /*Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);*/
    }

    //两道简单题.....
    public static int reverse(int x) {
        if (x == 0)
            return x;
        String src = String.valueOf(Math.abs(x));
        String maxString = String.valueOf(Integer.MAX_VALUE);
        String result;
        if (x >= Integer.MIN_VALUE && x < -1000000001) {
            result = judgeBigNumber(src, maxString, true);
            return 0 - Integer.parseInt(result);
        } else if (x <= Integer.MAX_VALUE && x > 1000000001) {
            result = judgeBigNumber(src, maxString, true);
            return Integer.parseInt(result);
        }
        result = judgeBigNumber(src, maxString, false);
        if (x < 0)
            return 0 - Integer.parseInt(result);
        else
            return Integer.parseInt(result);
    }

    private static String judgeBigNumber(String src, String maxString, boolean isNeedJudge) {
        StringBuilder result = new StringBuilder();
        for (int count = 0; count < src.length(); count++) {
            if (src.charAt(src.length() - count - 1) == '0' && result.length() == 0)
                continue;
            if (isNeedJudge) {
                if (maxString.charAt(count) > src.charAt(src.length() - count - 1))
                    isNeedJudge = false;
                else if (maxString.charAt(count) < src.charAt(src.length() - count - 1))
                    return "0";
            }
            result.append(src.charAt(src.length() - count - 1));
        }
        return result.toString();
    }
}
