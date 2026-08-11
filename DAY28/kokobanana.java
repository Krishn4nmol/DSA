import java.util.*;
public class kokobanana {
    static int find(int arr[], int h) { // TC O(n*max(arr)) SC O(1)
        int max = 0;
        for (int x : arr) {
            max = Math.max(max, x);
        }
        for (int k = 1; k <= max; k++) {
            int hours = 0;
            for (int x : arr) {
                hours += (x + k - 1) / k;
            }
            if (hours <= h) return k;
        }
        return max;
    }
    static int find1(int arr[], int h) { // TC O(n*log(max(arr))) SC O(1)
        int low = 1;
        int high = 0;
        for (int x : arr) {
            high = Math.max(high, x);
        }
        while (low <= high) {
            int k = low + (high - low) / 2;
            int hours = 0;
            for (int x : arr) {
                hours += (x + k - 1) / k;
            }
            if (hours <= h) high = k - 1;
            else low = k + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int h = sc.nextInt();
        System.out.println(find(arr, h));
        System.out.println(find1(arr, h));
    }
}