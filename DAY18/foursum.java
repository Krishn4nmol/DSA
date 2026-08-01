import java.util.*;
public class foursum {
    static void print(int arr[], int k) { // TC O(n^4) SC O(1)
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    for (int m = l + 1; m < n; m++) {
                        int sum = arr[i] + arr[j] + arr[l] + arr[m];
                        if (sum == k) {
                            System.out.println(i + " " + j + " " + l + " " + m);
                            flag = true;
                        }
                    }
                }
            }
        }
        if (!flag) System.out.println("Not found");
    }
    static void print1(int arr[], int k) { // TC O(n^3) SC O(n)
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int l = j + 1; l < n; l++) {
                    int target = k - (arr[i] + arr[j] + arr[l]);
                    if (map.containsKey(target)) {
                        System.out.println(i + " " + j + " " + l + " " + map.get(target));
                        flag = true;
                    }
                    map.put(arr[l], l);
                }
            }
        }
        if (!flag) System.out.println("Not found");
    }
    static void print2(int arr[], int k) { // TC O(n^3) SC O(1)
        Arrays.sort(arr);
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n-2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == k) {
                        System.out.println(i + " " + j + " " + left + " " + right);
                        flag = true;
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    }
                    else if (sum > k) {
                        right--;
                    }
                    else {
                        left++;
                    }
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