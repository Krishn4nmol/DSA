import java.util.*;
public class sudoku {
    static boolean solve(char board[][]) { // TC O(9^E) SC O(E)
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isSafe(char board[][], int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;
            if (board[r][c] == num) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char board[][] = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String s = sc.next();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j); // board[i][j] = sc.next().charAt(0);
            }
        }
        if (solve(board)) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Cannot be solved");
        }
    }
}