import java.util.*;
public class freqone {
    static int print(int arr[]) { // TC O(logn) SC O(1)
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) mid--;
            if (arr[mid] == arr[mid + 1]) low = mid + 2;
            else high = mid;
        }
        return arr[low];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(print(arr));
    }
}