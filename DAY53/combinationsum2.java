import java.util.*;
public class combinationsum2 { // TC O(2^n) SC O(n)
    static void generate(int arr[], int i, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (i == arr.length) {
            return;
        }
        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1]) continue;
            if (arr[j] > target) break;
            curr.add(arr[j]);
            generate(arr, j + 1, target - arr[j], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int target = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        generate(arr, 0, target, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}