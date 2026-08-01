import java.util.*;
public class foursumclosest {
    static int print(int arr[], int k) { // TC O(n^3) SC O(1)
        Arrays.sort(arr);
        int n = arr.length;
        int closest = arr[0] + arr[1] + arr[2] + arr[3];
        for (int i = 0; i < n-3; i++) {
            for (int j = i + 1; j < n-2; j++) {
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (Math.abs(sum - k) < Math.abs(closest - k)) {
                        closest = sum;
                    }
                    if (sum == k) {
                        return sum;
                    }
                    else if (sum > k) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(print(arr, k));
    }
}