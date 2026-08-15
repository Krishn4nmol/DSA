import java.util.*;
public class searchinmat {
    static boolean find(int arr[][], int k) { // TC O(log(nm)) SC O(1)
        int n = arr.length;
        int m = arr[0].length;
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;
            if (arr[row][col] == k) {
                return true;
            }
            else if (arr[row][col] < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
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
    }
}