import java.util.*;
public class lc66 {
    static int[] plusone(int arr[], int i) { // TC O(n) SC O(n)
        int n = arr.length;
        if (i >= n) {
            int temp[] = new int[n+1];
            temp[0] = 1;
            return temp;
        }
        arr[n-1-i]++;
        if (arr[n-1-i] < 10)
            return arr;
        arr[n-1-i] = 0;
        return plusone(arr, i+1);
    }
    static int[] plusone1(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        for (int i = n-1; i >= 0; i--) {
            arr[i]++;
            if (arr[i] < 10) {
                return arr;
            }
            arr[i] = 0;
        }
        int temp[] = new int[n+1];
        temp[0] = 1;
        return temp;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int brr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
            brr[i] = x;
        }
        int arr1[] = plusone(arr, 0);
        for (int x : arr1)
            System.out.print(x + " ");
        System.out.println();
        int arr2[] = plusone1(brr);
        for (int x : arr2)
            System.out.print(x + " ");
    }
}