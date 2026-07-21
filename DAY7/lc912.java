import java.util.*;
public class lc912 {
    static int[] sort(int arr[]) { // TC O(nlogn) SC O(n)
        mergesort(arr, 0, arr.length-1);
        return arr;
    }
    static void mergesort(int arr[], int low, int high) {
        if (low >= high) return;
        int mid = low + (high-low)/2;
        mergesort(arr, low, mid);
        mergesort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    static void merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int k = 0;
        int temp[] = new int[high-low+1];
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp[k++] = arr[left++];
            else
                temp[k++] = arr[right++];
        }
        while (left <= mid) temp[k++] = arr[left++];
        while (right <= high) temp[k++] = arr[right++];
        for (int i = low; i <= high; i++)
            arr[i] = temp[i-low];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sort(arr);
        for (int x : arr)
            System.out.print(x + " ");
    }
}