import java.util.*;
public class recselectionsort {
    static void sort(int arr[], int i) { // TC O(n^2) SC O(n)
        int n = arr.length;
        if (i >= n - 1) return;
        int min = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min]) min = j;
        }
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
        sort(arr, i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sort(arr,0);
        for (int x : arr)
            System.out.print(x + " ");
    }
}