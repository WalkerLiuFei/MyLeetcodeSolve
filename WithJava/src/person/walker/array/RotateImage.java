package person.walker.array;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class RotateImage {
    /*
        1,2,3                 7,8,9                7,4,1
        4,5,6  --行翻转--->   4,5,6 -对角翻转- >   8,5,2
        7,8,9                1,2,3                9,6,3
     */
    public void rotate(int[][] matrix) {
        for (int index = 0; index < matrix.length/2;index++){
            int[] temp = matrix[index];
            matrix[index] = matrix[matrix.length - index - 1];
            matrix[matrix.length - index - 1] = temp;
        }
        for (int row = 0; row < matrix.length  ; row++){
            for (int vertical = row + 1; vertical < matrix.length ; vertical++) {
                int temp = matrix[vertical][row];
                matrix[vertical][row] = matrix[row][vertical];
                matrix[row][vertical] = temp;
            }
        }


    }


    @Test
    public void test() {
        new RotateImage().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
