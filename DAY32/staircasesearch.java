import java.util.*;
public class staircasesearch {
    static boolean find(int arr[][], int k) { // TC O(n + m) SC O(1)
        int n = arr.length;
        int m = arr[0].length;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (arr[row][col] == k) {
                return true;
            }
            else if (arr[row][col] > k) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
    static boolean find1(int arr[][], int k) { // TC O(n + m) SC O(1)
        int n = arr.length;
        int m = arr[0].length;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < m) {
            if (arr[row][col] == k) {
                return true;
            }
            else if (arr[row][col] > k) {
                row--;  
            }
            else {
                col++; 
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        System.out.println(find(arr, k));
        System.out.println(find1(arr, k));
    }
}