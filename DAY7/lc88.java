import java.util.*;
public class lc88 {
    static void merge1(int arr1[], int n, int arr2[], int m) { // TC O(n+m) SC O(n+m)
        int left = 0;
        int right = 0;
        int k = 0;
        int temp[] = new int[n+m];
        while (left <= n - 1 && right <= m - 1) {
            if (arr1[left] <= arr2[right])
                temp[k++] = arr1[left++];
            else 
                temp[k++] = arr2[right++];
        }
        while (left <= n - 1)
            temp[k++] = arr1[left++];
        while (right <= m - 1)
            temp[k++] = arr2[right++];
        for (int i = 0; i < n+m; i++)
            arr1[i] = temp[i];
    }
    static void merge2(int arr1[], int n, int arr2[], int m) { // TC O(n+m) SC O(1)
        int i = n-1;
        int j = m-1;
        int k = n+m-1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] <= arr2[j])
                arr1[k--] = arr2[j--];
            else
                arr1[k--] = arr1[i--];
        }
        while (j >= 0)
            arr1[k--] = arr2[j--];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr1a[] = new int[n+m];
        int arr1b[] = new int[n+m];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr1a[i] = x;
            arr1b[i] = x;
        }
        int arr2[] = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        merge1(arr1a, n, arr2, m);
        for (int x : arr1a)
            System.out.print(x + " ");
        System.out.println();
        merge2(arr1b, n, arr2, m);
        for (int x : arr1b)
            System.out.print(x + " ");
    }
}