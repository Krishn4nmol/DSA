import java.util.*;
public class arraypowerset { // TC O(n * 2^n) SC O(n)
    static void generate(int arr[], int i, List<Integer> curr, List<List<Integer>> ans) {
        if (i == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[i]);
        generate(arr, i + 1, curr, ans);
        curr.remove(curr.size() - 1);
        generate(arr, i + 1, curr, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        generate(arr, 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}