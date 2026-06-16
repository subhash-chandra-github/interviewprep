package practice;

class Solution {
    int[] row = { -1, 0, 1, 0 };
    int[] col = { 0, 1, 0, -1 };
    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, board, visited, word, n, m, 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(int i, int j, char[][] board, boolean[][] visited, String word, int n, int m, Integer idx) {
        if (idx == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + row[k];
            int y = j + col[k];
            if (x >= 0 && y >= 0 && x < n && y < m && visited[x][y] == false && board[x][y] == word.charAt(idx)) {
                if (dfs(x, y, board, visited, word, n, m, idx + 1)) {
                    return true;
                }
            }

        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String  word = "ABCB";
        Solution solution = new Solution();
        System.out.println(solution.exist(board,word));
    }
}
