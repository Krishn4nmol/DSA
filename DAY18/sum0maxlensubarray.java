import java.util.*;
public class sum0maxlensubarray {
    static int print(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n;  j++) {
                sum += arr[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
    static int print1(int arr[]) { // TC O(n) SC O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int max = 0;
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            if (prefix == 0) {
                max = Math.max(max, i + 1);
            }
            else if (map.containsKey(prefix)) {
                max = Math.max(max, i - map.get(prefix));
            }
            if (!map.containsKey(prefix)) {
                map.put(prefix, i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(print(arr));
        System.out.println(print1(arr));
    }
}