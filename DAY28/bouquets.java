import java.util.*;
public class bouquets {
    static boolean canmake(int arr[], int day, int m, int k) {
        int flowers = 0;
        int bouquets = 0;
        for (int x : arr) {
            if (x <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            }
            else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
    static int find(int arr[], int m, int k) { // TC O(n*(max(arr)-min(arr)+1)) SC O(1)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        for (int i = min; i <= max; i++) {
            if (canmake(arr, i, m, k)) return i;
        }
        return -1;
    }
    static int find1(int arr[], int m, int k) { // TC O(n*log((max(arr)-min(arr)+1))) SC O(1)
        if ((long) m * k > arr.length) return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int x : arr) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }
        int ans = -1;
        while (low <= high) {
            int l = low + (high - low) / 2;
            if (canmake(arr, l, m, k)) {
                ans = l;
                high = l - 1;
            }
            else {
                low = l + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(find(arr, m, k));
        System.out.println(find1(arr, m, k));
    }
}