import java.util.*;
public class subarraysk {
    static int print(int arr[], int k) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    static int print1(int arr[], int k) { // TC O(n) SC O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
    static int print2(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        int sum = arr[0];
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                count++;
            }
            right++;
            if (right < n) {
                sum += arr[right];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(print(arr, k));
        System.out.println(print1(arr, k));
        System.out.println(print2(arr, k));
    }
}