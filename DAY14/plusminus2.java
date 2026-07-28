import java.util.*;
public class plusminus2 {
    static int[] solve(int arr[]) { // TC O(n) SC O(n)
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int x : arr) {
            if (x > 0) pos.add(x);
            else neg.add(x);
        }
        int p = 0, n = 0, i = 0;
        while (p < pos.size() && n < neg.size()) {
            arr[i++] = pos.get(p++);
            arr[i++] = neg.get(n++); 
        }
        while (p < pos.size()) {
            arr[i++] = pos.get(p++);
        }
        while (n < neg.size()) {
            arr[i++] = neg.get(n++);
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int a[] = solve(arr);
        for (int x : a)
            System.out.print(x + " ");
    }
}