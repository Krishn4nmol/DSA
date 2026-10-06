import java.util.*;
public class celebrity {
    static int find(int arr[][]) { // TC O(n) SC O(1)
        int n = arr.length;
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (arr[a][b] == 1) {
                a++;
            }
            else {
                b--;
            }
        }
        int candidate = a;
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(find(arr));
        sc.close();
    }
}