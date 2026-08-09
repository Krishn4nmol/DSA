import java.util.*;
public class countrot {
    static int count(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        int mini = 0;
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                mini = i;
            }
        }
        return mini;
    }
    static int count1(int arr[]) { // TC O(logn) SC O(1)
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(count(arr));
        System.out.println(count1(arr));
    }
}