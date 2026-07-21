import java.util.*;
public class recbubblesort {
    static void sort(int arr[], int i) { // TC O(n^2) AC WC O(n) BC SC O(n)
        int n = arr.length;
        if (i >= n - 1) return;
        boolean swap = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swap = true;
            }
        }
        if (!swap) return;
        sort(arr, i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        sort(arr, 0);
        for (int x : arr)
            System.out.print(x + " ");
    }
}