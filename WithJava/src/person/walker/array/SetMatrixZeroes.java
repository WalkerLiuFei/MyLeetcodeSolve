package person.walker.array;

import org.junit.Test;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean isColumnOneHasZero = false; //
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0)
                isColumnOneHasZero = true;

            for (int column = 1; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }
        for (int row =  matrix.length -1; row >=0; row--) { //从前往后 遍历会破坏原有的状态策略，所以只能从后往前遍历
            for (int column = matrix[row].length - 1; column > 0; column--) { //
                if (matrix[0][column] == 0 || matrix[row][0] == 0) {
                    matrix[row][column] = 0;
                }
            }
            if (isColumnOneHasZero)
                matrix[row][0] = 0;
        }
        System.out.println();
    }

    @Test
    public void test() {
        new SetMatrixZeroes().setZeroes(new int[][]{{1,1,1}, {0,1,2}});
    }
}
