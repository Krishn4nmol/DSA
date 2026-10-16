import java.util.*;
public class jumpgame {
    static boolean check(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) return false;
            max = Math.max(max, i + arr[i]);
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(check(arr));
    }
}