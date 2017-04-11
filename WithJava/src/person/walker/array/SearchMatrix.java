package person.walker.array;

import org.junit.Test;

/**
 * Created by Administrator on 2017/1/22 0022.
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        if (matrix.length < 1 || matrix[right] .length < 1 || target < matrix[0][0] ||  matrix[right][matrix[right].length - 1] < target)
            return false;
        int targetRow = left;
        while (right >= left){
            targetRow = left + (right - left) / 2;
            int startEle = matrix[targetRow][0];
            int endEle = matrix[targetRow][matrix[targetRow].length -1];
            if (startEle < target && target < endEle){ //找到了合适的区间
                break;
            }else if (startEle > target){
                right = targetRow - 1;
            }else if (endEle < target){
                left = targetRow + 1;
            }else if (startEle == target || endEle == target)
                return true;
            else
                return false;
        }
        left = 0;
        right = matrix[targetRow].length - 1;
        while (right >= left){
            int targetColumn = left + (right - left) /2;
            if (matrix[targetRow][targetColumn] > target){
                right = targetColumn - 1;
            }else if (matrix[targetRow][targetColumn] < target){
                left = targetColumn + 1;
            }else {
                return true;
            }
        }
        return  false;
    }
    @Test
    public void test(){
      // System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1,3,5,7},{4,8,14,18},{4,8,10,45}},14));
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1}},1));
    }
}
