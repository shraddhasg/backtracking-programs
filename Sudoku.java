
class Sudoku {

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sudoku(int[][] board, int i, int j) {
        // System.out.println("i=" + i + " board length=" + board.length);

        if (i == board.length) {
            display(board);
            return;
        }
        // System.out.println("===============");

        int newi = 0;
        int newj = 0;

        if (j == board[0].length - 1) {
            newi = i + 1;
            newj = 0;
        } else {
            newi = i;
            newj = j + 1;
        }

        // System.out.println("new i =" + newi + " " + "newj=" + newj);
        if (board[i][j] != 0) {
            sudoku(board, newi, newj);
        } else {
            for (int possible = 1; possible <= 9; possible++) {
                if (isValid(board, i, j, possible) == true) {
                    board[i][j] = possible;
                    sudoku(board, newi, newj);
                    board[i][j] = 0;
                }
            }
        }

    }

    public static boolean isValid(int[][] arr, int x, int y, int val) {

        // System.out.println("isvalid ==========");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][y] == val)
                return false;
        }

        for (int j = 0; j < arr[0].length; j++) {
            if (arr[x][j] == val)
                return false;
        }

        int subMatrixI = x / 3 * 3;
        int subMatrixJ = y / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i + subMatrixI][j + subMatrixJ] == val)
                    return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        display(board);

        System.out.println();

        sudoku(board, 0, 0);

    }

}