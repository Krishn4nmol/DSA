import java.util.*;
public class mergesorted {
    static void print(int arr[], int brr[]) { // TC O(n+m) SC O(n+m)
        int n = arr.length;
        int m = brr.length;
        int temp[] = new int[n+m];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr[i] <= brr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = brr[j++];
            }
        }
        while (i < n) {
            temp[k++] = arr[i++];
        }
        while (j < m) {
            temp[k++] = brr[j++];
        }
        for (int l = 0; l < n; l++) {
            arr[l] = temp[l];
        }
        for (int l = 0; l < m; l++) {
            brr[l] = temp[n + l];
        }
    }
    static void print1(int arr[], int brr[]) { // TC O(min(n, m) + nlogn + mlogm) SC O(1) swap and sort
        int n = arr.length;
        int m = brr.length;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j <= m - 1) {
            if (arr[i] > brr[j]) {
                int temp = arr[i];
                arr[i] = brr[j];
                brr[j] = temp;
                i--;
                j++;
            }
            else {
                break;
            }
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
    }
    static void swap(int arr[], int brr[], int i, int j) {
        if (arr[i] > brr[j]) {
            int temp = arr[i];
            arr[i] = brr[j];
            brr[j] = temp;
        }
    }
    static void print2(int arr[], int brr[]) { // TC O((n+m)log(n+m)) SC O(1) shell sort
        int n = arr.length;
        int m = brr.length;
        int len = n + m;
        int gap = (len + 1) / 2;
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right < n) {
                    swap(arr, arr, left, right);
                }
                else if (left < n && right >= n) {
                    swap(arr, brr, left, right - n);
                }
                else if (left >= n && right >= n) {
                    swap(brr, brr, left - n, right - n);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap + 1) / 2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int brr[] = new int[m];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) 
            brr[i] = sc.nextInt();
        print(arr, brr);
        print1(arr, brr);
        print2(arr, brr);
    }
}