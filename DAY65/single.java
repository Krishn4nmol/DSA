import java.util.*;
public class single {
    static int find(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count == 1) {
                return arr[i];
            }
        }
        return -1;
    }
    static int find1(int arr[]) { // TC O(nlogn) SC O(1)
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        return arr[n - 1];
    }
    static int find2(int arr[]) { // TC O(n) SC O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x,0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
    static int find3(int arr[]) { // TC O(n) SC O(1)
        int xor = 0;
        for (int x : arr) {
            xor ^= x;
        }
        return xor;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(find(arr));
        System.out.println(find1(arr.clone()));
        System.out.println(find2(arr));
        System.out.println(find3(arr));
    }
}