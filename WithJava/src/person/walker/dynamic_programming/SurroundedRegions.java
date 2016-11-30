package person.walker.dynamic_programming;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length <= 1)
            return;

        int rowNum = board.length;
        int columnNum = board[0].length;
        boolean[][] marked = new boolean[rowNum][columnNum];
        boolean isSurround = false;
        for (int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
            for (int columnIndex = 1; columnIndex < columnNum; columnIndex++) {
                if (board[rowIndex][columnIndex] == 'O' && !marked[rowIndex][columnIndex]) {
                    if (marked[rowIndex][columnIndex]) {//如果这个被标记 且状态为surround
                        if (isSurround)
                            board[rowIndex][columnIndex] = 'X';
                        continue;
                    }
                    isSurround = bfs(board, marked, rowIndex, columnIndex);
                    if (isSurround) //将当前的坐标处的O变为X
                        board[rowIndex][columnIndex] = 'X';
                }
                marked[rowIndex][columnIndex] = true;
            }
        }
    }

    private boolean bfs(char[][] board, boolean[][] marked, int rowIndex, int columnIndex) {
        //只要是到达了边界，且迭代还没结束，就是不是被包围了
        if (rowIndex == 0
                || columnIndex == 0
                || rowIndex == board.length -1
                || columnIndex == board[rowIndex].length - 1)
            return false;
        marked[rowIndex][columnIndex] = true;
        //查询四个方向,如果任意一个方向的元素是 ‘0’ 那么就继续search, 直到终点或者到了某个元素，四个方向没有满足的，就会返回false
        if (!marked[rowIndex - 1][columnIndex] && board[rowIndex - 1][columnIndex] == 'O')
            bfs(board, marked, rowIndex - 1, columnIndex);

        if (!marked[rowIndex + 1][columnIndex] && board[rowIndex + 1][columnIndex] == 'O')
            bfs(board, marked, rowIndex + 1, columnIndex);

        if (!marked[rowIndex][columnIndex - 1] && board[rowIndex][columnIndex - 1] == 'O')
            bfs(board, marked, rowIndex, columnIndex - 1);

        if (!marked[rowIndex][columnIndex + 1] && board[rowIndex][columnIndex + 1] == 'O')
            bfs(board, marked, rowIndex, columnIndex + 1);
        return true;
    }

    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][]{{'O', 'O', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
        System.out.println();
    }
}
