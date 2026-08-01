import java.util.*;
public class ksum {
    static List<List<Integer>> print(int arr[], int target, int k) { // TC O(n^k-1) SC O(k) rec stack space
        Arrays.sort(arr);
        return helper(arr, 0, target, k);
    }
    static List<List<Integer>> helper(int arr[], int start, int target, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        if (k == 2) {
            int left = start;
            int right = n - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == target) {
                    ans.add(Arrays.asList(arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1])
                        left++;
                    while (left < right && arr[right] == arr[right + 1])
                        right--;
                }
                else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
            return ans;
        }
        for (int i = start; i <= n - k; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            List<List<Integer>> temp = helper(arr, i + 1, target - arr[i], k - 1);
            for (List<Integer> list : temp) {
                List<Integer> curr = new ArrayList<>();
                curr.add(arr[i]);
                curr.addAll(list);
                ans.add(curr);
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
        int target = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(print(arr, target, k));
    }
}