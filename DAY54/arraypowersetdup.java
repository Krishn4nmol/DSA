import java.util.*;
public class arraypowersetdup {
    static List<List<Integer>> generate(int arr[]) { // TC o(n * 2^n) SC O(2^n)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        generate1(arr, 0, new ArrayList<>(), ans);
        return ans;
    }
    static void generate1(int arr[], int i, List<Integer> curr, List<List<Integer>> ans) { 
        if (i == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[i]);
        generate1(arr, i + 1, curr, ans);
        curr.remove(curr.size() - 1);
        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            i++;
        }
        generate1(arr, i + 1, curr, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(generate(arr));
    }
}