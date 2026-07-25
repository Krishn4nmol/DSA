import java.util.*;
public class maxsubarraywithk2 {
    static void print1(int arr[], int k) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int left = -1;
        int right = -1;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    int len = j - i + 1;
                    if (len > maxlen) {
                        maxlen = len;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        if (left == -1) {
            System.out.println("No subarray found");
            return;
        }
        System.out.println("MaxLen = " + maxlen);
        for (int i = left; i <= right; i++)
            System.out.print(arr[i] + " ");
    }
    static void print2(int arr[], int k) { // TC O(n) SC O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int maxlen = 0;
        int left = -1;
        int right = -1;
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            if (prefix == k) {
                int len = i + 1;
                if (len > maxlen) {
                    maxlen = len;
                    left = 0;
                    right = i;
                }
            }
            if (map.containsKey(prefix - k)) {
                int len = i - map.get(prefix - k);
                if (len > maxlen) {
                    maxlen = len;
                    left = map.get(prefix - k) + 1;
                    right = i;
                }
            }
            if (!map.containsKey(prefix)) {
                map.put(prefix, i);
            }
        }
        if (left == -1) {
            System.out.println("No subarray found");
            return;
        }
        System.out.println("MaxLen = " + maxlen);
        for (int i = left; i <= right; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        print1(arr, k);
        System.out.println();
        print2(arr, k);
    }
}