import java.util.*;
public class subsumk { // TC O(2^n) SC O(n)
    static int generate(int arr[], int i, int sum, int k) {
        if (i == arr.length) {
            if (sum == k) return 1;
            return 0;
        }
        int take = generate(arr, i + 1, sum + arr[i], k);
        int nottake = generate(arr, i + 1, sum, k);
        return take + nottake;
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