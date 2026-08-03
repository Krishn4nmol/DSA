import java.util.*;
public class overlapintervals {
    static List<List<Integer>> print(int arr[][]) { // TC O(n^2) SC O(n)
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1))
                continue;
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                }
                else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }
    static int[][] print1(int arr[][]) { // TC O(nlogn) SC O(n)
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (ans.isEmpty()) {
                ans.add(Arrays.asList(start, end));
            }
            else {
                int last = ans.get(ans.size()-1).get(1);
                if (start <= last) {
                    ans.get(ans.size()-1).set(1, Math.max(last, end));
                }
                else {
                    ans.add(Arrays.asList(start, end));
                }
            }
        }
        int a[][] = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            a[i][0] = ans.get(i).get(0);
            a[i][1] = ans.get(i).get(1);
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(print(arr));
        int[][] ans = print1(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}