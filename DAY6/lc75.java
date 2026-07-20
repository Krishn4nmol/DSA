import java.util.*;
public class lc75 { //Dutch National Flag algo TC O(n) SC O(1)
    static void sort(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++; mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
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