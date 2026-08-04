import java.util.*;
public class freq2freq0 {
    static int[] print(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int missing = -1;
        int repeat = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }
            if (count == 0) {
                missing = i;
            }
            else if (count == 2) {
                repeat = i;
            }
        }
        return new int[] {repeat, missing};
    }
    static int[] print1(int arr[]) { // TC O(n) SC O(n)
        int n = arr.length;
        int missing = -1;
        int repeat = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                missing = i;
            }
            else if (map.get(i) == 2) {
                repeat = i;
            }
        }
        return new int[] {repeat, missing};
    }
    static int[] print2(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        int expected = n * (n + 1) / 2;
        int expecteds = (n * (n + 1) * (2 * n + 1)) / 6;
        int actual = 0;
        int actuals = 0;
        for (int x : arr) {
            actual += x;
            actuals += x * x;
        }
        int diff = actual - expected;
        int diffs = actuals - expecteds;
        int sum = diffs / diff;
        int repeat = (sum + diff) / 2;
        int missing = repeat - diff;
        return new int[] {repeat, missing};
    }
    static int[] print3(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        int xor = 0;
        for (int x : arr) {
            xor ^= x;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int bit = xor & -xor;
        int bucket1 = 0;
        int bucket2 = 0;
        for (int x : arr) {
            if ((x & bit) != 0) {
                bucket1 ^= x;
            }
            else {
                bucket2 ^= x;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & bit) != 0) {
                bucket1 ^= i;
            }
            else {
                bucket2 ^= i;
            }
        }
        for (int x : arr) {
            if (x == bucket1) {
                return new int[] {bucket1, bucket2};
            }
        }
        return new int[] {bucket2, bucket1};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int a[] = print(arr);
        for (int x : a)
            System.out.print(x + " ");
        int b[] = print1(arr);
        for (int x : b)
            System.out.print(x + " ");
        int c[] = print2(arr);
        for (int x : c)
            System.out.print(x + " ");
        int d[] = print3(arr);
        for (int x : d)
            System.out.print(x + " ");
    }
}