import java.util.*;
public class twosumsorted {
    static void print(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        boolean found = false;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) {
                System.out.println(left + " " + right);
                found = true;
                left++;
                right--;
            }
            else if (sum < k) left++;
            else right--;
        }
        if (!found) System.out.println("No two sum exists");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        print(arr, k);
    }
}