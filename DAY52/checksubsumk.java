import java.util.*;
public class checksubsumk { // TC O(2^n) SC O(n)
    static boolean generate(int arr[], int i, int sum, int k) {
        if (i == arr.length) {
            return sum == k;
        }
        boolean take = generate(arr, i + 1, sum + arr[i], k);
        if (take) return true;
        boolean nottake = generate(arr, i + 1, sum, k);
        return nottake;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(generate(arr, 0, 0, k));
    }
}