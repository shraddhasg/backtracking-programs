public class NQueenProblem {

    public static void nQueenProblem(boolean[][] board, int row, boolean[] col, boolean[] diagonal,
            boolean[] revDiagonal, String ans) {

        if (row == board.length) {
            System.out.println(ans + ".");
            return;
        }

        for (int column = 0; column < board[0].length; column++) {
            if (col[column] == false && diagonal[row + column] == false
                    && revDiagonal[row - column + board.length - 1] == false) {

                board[row][column] = true;
                col[column] = true;
                diagonal[row + column] = true;
                revDiagonal[row - column + board.length - 1] = true;

                nQueenProblem(board, row + 1, col, diagonal, revDiagonal, ans + row + "-" + column + "-");

                board[row][column] = false;
                col[column] = false;
                diagonal[row + column] = false;
                revDiagonal[row - column + board.length - 1] = false;
            }
        }

    }

    public static void main(String[] args) {

        int n;
        n = 4;

        boolean[][] board = new boolean[n][n];

        boolean[] col = new boolean[n];
        boolean[] diagonal = new boolean[2 * n - 1];
        boolean[] revDiagonal = new boolean[2 * n - 1];
        int row = 0;
        String ans = "";

        nQueenProblem(board, row, col, diagonal, revDiagonal, ans);
    }
}
