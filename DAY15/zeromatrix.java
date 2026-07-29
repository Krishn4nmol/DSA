import java.util.*;
public class zeromatrix {
    static void rowset(int arr[][], int row, int m) {
        for (int i = 0; i < m; i++) {
            if (arr[row][i] != 0) {
                arr[row][i] = -1;
            }
        }
    }
    static void colset(int arr[][], int col, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i][col] != 0) {
                arr[i][col] = -1;
            }
        }
    }
    static void find(int arr[][]) { // TC O((nm)(n+m)) SC O(1)
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    rowset(arr, i, m);
                    colset(arr, j, n);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }
    static void find1(int arr[][]) { // TC O(nm) SC O(1)
        int n = arr.length;
        int m = arr[0].length;
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) 
                col0 = 0;
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
            if (col0 == 0) {
                arr[i][0] = 0;
            }
        }  
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        int brr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                arr[i][j] = x;
                brr[i][j] = x;
            }
        }
        find(arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        find1(brr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}