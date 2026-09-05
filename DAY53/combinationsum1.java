import java.util.*;
public class combinationsum1 { // TC O(2^T) SC O(T) where T = Target
    static void generate(int arr[], int i, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (i == arr.length) {
            return;
        }
        if (arr[i] <= target) {
            curr.add(arr[i]);
            generate(arr, i, target - arr[i], curr, ans);
            curr.remove(curr.size() - 1);
        }
        generate(arr, i + 1, target, curr, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int target = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        generate(arr, 0, target, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}