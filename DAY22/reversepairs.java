import java.util.*;
public class reversepairs {
    static int print(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > 2L * arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    static int print1(int arr[], int low, int high) { // TC O(nlogn) SC O(n)
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = 0;
        count += print1(arr, low, mid);
        count += print1(arr, mid + 1, high);
        count += co(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }
    static int co(int arr[], int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }
            count += right - mid - 1;
        }
        return count;
    }
    static void merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int temp[] = new int[high - low + 1];
        int k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            }
            else {
                temp[k++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(print(arr));
        System.out.println(print1(arr, 0, n - 1));
    }
}