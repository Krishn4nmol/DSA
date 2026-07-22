import java.util.*; // TC O(nlogn) BC AC O(n^2) WC already sorted wrong pivot choose SC O(logn) BC AC O(n) WC
public class quicksort {
    static void sort(int arr[]) {
        quick(arr, 0, arr.length-1);
    }
    static void quick(int arr[], int low, int high) {
        if (low >= high) return;
        int index = pivot(arr, low, high);
        quick(arr, low, index-1);
        quick(arr, index+1, high);
    }
    static int pivot(int arr[], int low, int high) {
        int piv = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= high - 1 && arr[i] <= piv) i++; // for decreasing arr[i] >= piv
            while (j >= low + 1 && arr[j] > piv) j--; // for decreasing arr[j] < piv
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
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