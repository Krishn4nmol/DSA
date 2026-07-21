import java.util.*;
public class recinsertionsort {
    static void sort(int arr[], int i) { // TC O(n^2) AC WC O(n) BC SC O(n)
        if (i >= arr.length) return;
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j]  > key) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
        sort(arr, i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        sort(arr, 1);
        for (int x : arr)
            System.out.print(x + " ");
    }
}