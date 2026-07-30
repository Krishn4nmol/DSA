import java.util.*;
public class rotatematrix {
    static void rotate(int arr[][]) { // TC O(n^2) SC O(n^2)
        int n = arr.length;
        int m = arr[0].length;
        int a[][] = new int [m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[j][n - i - 1] = arr[i][j]; // a[n-j-1][i] = arr[i][j] for acw rotate
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void rotate1(int arr[][]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        rotate(arr);
        rotate1(arr);
    }
}