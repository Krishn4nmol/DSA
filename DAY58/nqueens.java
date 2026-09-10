import java.util.*;
public class nqueens { // TC O(n!) SC O(n^2)
    static List<List<String>> ans = new ArrayList<>();
    static List<List<String>> solveN(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        boolean col[] = new boolean[n];
        boolean diag1[] = new boolean[2*n - 1];
        boolean diag2[] = new boolean[2*n - 1];
        dfs(0, n, board, col, diag1, diag2);
        return ans;
    }
    static void dfs(int row, int n, char board[][], boolean col[], boolean diag1[], boolean diag2[]) {
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < n; i++) 
                sol.add(new String(board[i]));
            ans.add(sol);
            return;
        }
        for (int c = 0; c < n; c++) {
            int d1 = row - c + n - 1;
            int d2 = row + c;
            if (col[c] || diag1[d1] || diag2[d2]) continue;
            board[row][c] = 'Q';
            col[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            dfs(row + 1, n, board, col, diag1, diag2); // dfs
            board[row][c] = '.'; // backtrack
            col[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> ans = solveN(n);
        for (List<String> list : ans) {
            for (String row : list) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}