import java.util.*;
public class sumofsubsets {
    static List<Integer> generate(int arr[]) { // bitmasking approach TC O(n * 2^n) SC O(2^n)
        List<Integer> ans = new ArrayList<>(); 
        int n = arr.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }
            ans.add(sum);
        }
        Collections.sort(ans);
        return ans;
    }
    static void generate1(int arr[], int i, int sum, List<Integer> ans) { // TC O(n * 2^n) SC O(2^n)
        if (i == arr.length) {
            ans.add(sum);
            return;
        }
        generate1(arr, i + 1, sum + arr[i], ans);
        generate1(arr, i + 1, sum, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(generate(arr));
        List<Integer> ans = new ArrayList<>();
        generate1(arr, 0, 0, ans);
        Collections.sort(ans);
        System.out.println(ans);
    }
}