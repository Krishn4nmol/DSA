import java.util.*;
public class wordsearch { // backtracking + dfs TC O(nm * 4^L) SC O(L) L = word length
    static boolean exist(char arr[][], String word) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == word.charAt(0)) {
                    if (dfs(arr, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static boolean dfs(char arr[][], String word, int i, int j, int k) {
        if (k == word.length()) return true;
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != word.charAt(k)) return false;
        char temp = arr[i][j];
        arr[i][j] = '#'; // choose
        boolean found = dfs(arr, word, i + 1, j, k + 1) ||
                        dfs(arr, word, i - 1, j, k + 1) ||
                        dfs(arr, word, i, j + 1, k + 1) ||
                        dfs(arr, word, i, j - 1, k + 1); // explore dfs
        arr[i][j] = temp; // backtrack
        return found;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in)
        int n = sc.nextInt();
        int m = sc.nextInt();
        char arr[][] = new char[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.next().charAt(0);
        String word = sc.next();
        System.out.println(exist(arr, word));
    }
}