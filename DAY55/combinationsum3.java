import java.util.*;
public class combinationsum3 { // TC O(2^9) SC O(n)
    static void generate(int start, int k, int n, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) break;
            curr.add(i);
            generate(i + 1, k, n - i, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        generate(1, k, n, new ArrayList<>(), ans);
        System.out.print(ans);
    }
}