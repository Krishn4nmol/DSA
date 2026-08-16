import java.util.*;
public class peakmat {
    static int[] find(int arr[][]) { // TC O(nlogm) SC O(1)
        int n = arr.length;
        int m = arr[0].length;
        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i][mid] > arr[max][mid]) {
                    max = i;
                }
            }
            int l = (mid - 1 >= 0) ? arr[max][mid - 1] : -1;
            int r = (mid + 1 <= m - 1) ? arr[max][mid + 1] : -1;
            if (arr[max][mid] > l && arr[max][mid] > r) {
                return new int[] {max, mid};
            }
            else if(arr[max][mid] < l) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return new int[] {-1, -1};
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
        System.out.println(Arrays.toString(find(arr)));
    }
}