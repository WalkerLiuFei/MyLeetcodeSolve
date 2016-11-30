package person.walker.backtracking;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        return dfs(board, word.hashCode(), 0, 0, 0,visited);
    }

    private boolean dfs(char[][] board, int targetHash, int vertical, int column, int currentHash, boolean[][] visited) {
        if (currentHash == targetHash)
            return true;
        else if (currentHash > targetHash && currentHash/targetHash >= 1 )
            return false;
        for (int verticalIndex = vertical; verticalIndex < board.length; verticalIndex++) {
            for (int columnIndex = column; columnIndex < board[verticalIndex].length; columnIndex++) {
                if (visited[verticalIndex][columnIndex])
                    continue;
                visited[verticalIndex][columnIndex] = true;
                int newHash = 31 * currentHash + board[verticalIndex][columnIndex];
                int nextVertical;
                int nextColumn;
                if (columnIndex + 1 == board[verticalIndex].length) {
                    nextVertical = verticalIndex + 1;
                    nextColumn = 0;
                } else {
                    nextVertical = verticalIndex;
                    nextColumn = columnIndex + 1;
                }
                if (dfs(board,targetHash, nextVertical, nextColumn, newHash, visited))
                    return true;
                visited[verticalIndex][columnIndex] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] nums = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        new WordSearch().exist(nums, "ABCSS");
    }
}
