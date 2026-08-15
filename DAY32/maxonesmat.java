import java.util.*;
public class maxonesmat {
    static int find(int arr[][]) { // TC O(nlogm) SC O(1)
        int n = arr.length;
        int m = arr[0].length;
        int max = -1;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            int first = m;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[i][mid] == 1) {
                    first = mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            int count = m - first;
            if (count > max) {
                max = count;
                ans = i;
            }
        }
        return ans;
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
        System.out.println(find(arr));
    }
}