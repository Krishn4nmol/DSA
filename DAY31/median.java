import java.util.*;
public class median {
    static double find(int arr[], int brr[]) { // TC O(log(min(a,b))) SC O(1)
        if (arr.length > brr.length) {
            return find(brr, arr);
        }
        int n = arr.length;
        int m = brr.length;
        int low = 0;
        int high = n;
        while (low <= high) {
            int gap1 = low;
            int gap2 = (n + m + 1) / 2 - gap1;
            int left1 = (gap1 == 0) ? Integer.MIN_VALUE : arr[gap1 - 1];
            int right1 = (gap1 == n) ? Integer.MAX_VALUE : arr[gap1];
            int left2 = (gap2 == 0) ? Integer.MIN_VALUE : brr[gap2 - 1];
            int right2 = (gap2 == m) ? Integer.MAX_VALUE : brr[gap2];
            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 1) {
                    return Math.max(left1, left2);
                }
                return ((Math.max(left1, left2) + Math.min(right1, right2)) / 2.0);
            }
            else if (left1 > right2) {
                high = gap1 - 1;
            }
            else {
                low = gap1 + 1;
            }
        }
        return -1;
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
        System.out.println(find(arr, brr));
    }
}