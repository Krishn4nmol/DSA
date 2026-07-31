import java.util.*;
public class threesum {
    static void print(int arr[], int k) { // TC O(n^3) SC O(1)
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    if (arr[i] + arr[j] + arr[l] == k) {
                        System.out.println(i + " " + j + " " + l);
                        flag = true;
                    }
                }
            }
        }
        if (!flag) System.out.println("Not found");
    }
    static void print1(int arr[], int k) { // TC O(n^2) SC O(n)
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int target = k - (arr[i] + arr[j]);
                if (map.containsKey(target)) {
                    System.out.println(i + " " + j + " " + map.get(target));
                    flag = true;
                }
                map.put(arr[j], j);
            }
        }
        if (!flag) System.out.println("Not found");
    }
    static void print2(int arr[], int k) { // TC O(n^2) SC O(1)
        int n = arr.length;
        Arrays.sort(arr);
        boolean flag = false;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == k) {
                    System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                    flag = true;
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1])
                        left++;
                    while (left < right && arr[right] == arr[right + 1])
                        right--;
                }
                else if (sum > k) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        if (!flag) System.out.println("Not found");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        print(arr, k);
        print1(arr, k);
        print2(arr, k);
    }
}