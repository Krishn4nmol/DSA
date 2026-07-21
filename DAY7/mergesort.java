import java.util.*;
public class mergesort {
    static void merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int k = 0;
        int temp[] = new int[high-low+1];
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
            arr[i] = temp[i-low];
        }
    }
    static void sort(int arr[], int low, int high) { // TC O(nlogn) SC O(n + logn) = O(n)
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        sort(arr, 0, arr.length-1);
        for (int x : arr)
            System.out.print(x + " ");
    }
}