import java.util.*;
public class dutchflag {
    static void sort(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        int left = 0;
        int mid = 0;
        int right = n - 1;
        while (mid <= right) {
            if (arr[mid] == 0) {
                int temp = arr[left];
                arr[left] = arr[mid];
                arr[mid] = temp;
                mid++;
                left++;
            }
            else if(arr[mid] == 1) mid++;
            else {
                int temp = arr[right];
                arr[right] = arr[mid];
                arr[mid] = temp;
                right--;
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