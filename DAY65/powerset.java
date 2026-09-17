import java.util.*;
public class powerset {
    static List<List<Integer>> print(int arr[]) { // TC O(n * 2^n) SC O(n * 2^n)
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(arr[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        System.out.println(print(arr));
    }
}