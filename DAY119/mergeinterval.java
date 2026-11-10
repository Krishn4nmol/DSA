import java.util.*;
public class mergeinterval { // TC O(nlogn) SC O(n)
    static int[][] merge(int intervals[][]) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        for (int interval[] : intervals) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(interval.clone());
            } else {
                int last[] = ans.get(ans.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int intervals[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int ans[][] = merge(intervals);
        for (int interval[] : ans) {
            System.out.println(interval[0] + " " + interval[1]);
        }
        sc.close();
    }
}