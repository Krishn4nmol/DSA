import java.util.*;
public class singlenumbergoldman {
    static int find(int arr[]) { // TC O(n) SC O(1)
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) { // for k times repeat use (count % k != 0)
                ans |= (1 << bit);
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(find(arr));
        sc.close();
    }
}