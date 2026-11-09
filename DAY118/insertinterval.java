import java.util.*;
public class insertinterval { // TC O(n) SC O(n)
    static int[][] insert(int interval[][], int newinterval[]) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        int n = interval.length;
        while (i < n && interval[i][1] < newinterval[0]) {
            ans.add(interval[i]);
            i++;
        }
        while (i < n && interval[i][0] <= newinterval[1]) {
            newinterval[0] = Math.min(newinterval[0], interval[i][0]);
            newinterval[1] = Math.max(newinterval[1], interval[i][1]);
            i++;
        }
        ans.add(newinterval);
        while (i < n) {
            ans.add(interval[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int interval[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            interval[i][0] = sc.nextInt();
            interval[i][1] = sc.nextInt();
        }
        int newinterval[] = new int[2];
        newinterval[0] = sc.nextInt();
        newinterval[1] = sc.nextInt();
        System.out.println(Arrays.deepToString(insert(interval, newinterval)));
        sc.close();
    }
}