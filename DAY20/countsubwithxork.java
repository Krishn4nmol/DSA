import java.util.*;
public class countsubwithxork {
    static int count (int arr[], int k) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = i; j < n; j++) {
                x ^= arr[j];
                if (x == k) {
                    count++;
                }
            }
        }
        return count;
    }
    static int count1 (int arr[], int k) { // TC O(n) SC O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int count = 0;
        int prefix = 0;
        map.put(0, 1);
        for (int x : arr) {
            prefix ^= x;
            if (map.containsKey(prefix ^ k)) {
                count += map.get(prefix ^ k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int [n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(count(arr, k));
        System.out.println(count1(arr, k));
    }
}