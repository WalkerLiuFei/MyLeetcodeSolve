package person.walker.backtracking;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        return dfs(board, word.hashCode(), 0, 0, 0,visited,0,word.length());
    }

    private boolean dfs(char[][] board, int targetHash, int vertical, int column, int currentHash, boolean[][] visited, int currentLength, int lengthLimit) {
        if (currentHash == targetHash)
            return true;
        else if (currentLength >= lengthLimit )
            return false;
        for (int verticalIndex = 0; verticalIndex < board.length; verticalIndex++) {
            for (int columnIndex = 0; columnIndex < board[verticalIndex].length; columnIndex++) {
                if (visited[verticalIndex][columnIndex] ) continue;
                visited[verticalIndex][columnIndex] = true;
                currentLength += 1;
                visited[verticalIndex][columnIndex] = true;
                int newHash = 31 * currentHash + board[verticalIndex][columnIndex];
                if (dfs(board,targetHash, verticalIndex, columnIndex, newHash, visited, currentLength, lengthLimit))
                    return true;
                currentLength -= 1;
                visited[verticalIndex][columnIndex] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
      //  char[][] nums = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] nums = new char[][]{{'a'},{'a'}};
       System.out.println(new WordSearch().exist(nums, "aaa"));
    }
}
