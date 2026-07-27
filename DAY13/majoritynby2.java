import java.util.*;
public class majoritynby2 {
    static int find1(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) count++;
            }
            if (count > n/2) return arr[i];
        }
        return -1;
    }
    static int find2(int arr[]) { // TC O(n) SC O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > arr.length / 2) return entry.getKey();
        }
        return -1;
    }
    static int find3(int arr[]) { // TC O(n) SC O(1) MOORE'S VOTING ALGO
        int n = arr.length;
        int count = 0;
        int candidate = 0;
        for (int x : arr) {
            if (candidate == x) {
                count++;
            }
            else if (count == 0) {
                count = 1;
                candidate = x;
            }
            else {
                count--;
            }
        }
        int count1 = 0;
        for (int x : arr) {
            if (candidate == x) count1++;
        }
        return (count1 > n/2) ? candidate : -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(find1(arr));
        System.out.println(find2(arr));
        System.out.println(find3(arr));
    }
}