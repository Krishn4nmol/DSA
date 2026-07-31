import java.util.*;
public class pascal {
    static List<List<Integer>> print(int n) { // TC O(n^2) SC O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int x = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                    row.add(x);
                }
            }
            ans.add(row);
        }
        return ans;
    }
    static List<List<Integer>> print1(int n) { // TC O(n^2) SC O(n^2) binomial coefficient
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            int value = 1;
            for (int j = 1; j <= i; j++) {
                value = value * (i - j + 1) / j;
                row.add(value);
            }
            ans.add(row);
        }
        return ans;
    }
    static int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    static int print2(int row, int col) { // TC O(row) SC O(1)
        return fact(row-1)/(fact(col-1)*fact(row-col));
    }
    static int print3(int row, int col) { // TC O(col) SC O(1)
        int ans = 1;
        for (int i = 1; i <= col - 1; i++) {
            ans = ans * (row - i) / i;
        }
        return ans;
    }
    static List<Integer> print4(int n) { // TC O(n) SC O(n)
        List<Integer> ans = new ArrayList<>();
        int val = 1;
        ans.add(1);
        for (int i = 1; i < n; i++) {
            val = val * (n - i) / i;
            ans.add(val);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        System.out.println(print(n));
        System.out.println(print1(n));
        System.out.println(print2(k, l));
        System.out.println(print3(k, l));
        System.out.println(print4(k));
    }
}