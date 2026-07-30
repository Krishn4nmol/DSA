import java.util.*;
public class spiralmatrix {
    static ArrayList<Integer> print(int arr[][]) { // TC O(n^2) SC O(1)
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;
        int top = 0;
        int left = 0;
        int right = m - 1;
        int bottom = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(arr[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(arr[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(arr[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(arr[i][left]);
                }
                left++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(print(arr));
    }
}