import java.util.*;
public class singletwo {
    static int[] find(int arr[]) { // TC O(n) SC O(1)
        int xor = 0;
        for (int x : arr) {
            xor ^= x;
        }
        int bit = xor & -xor;
        int a = 0;
        int b = 0;
        for (int x : arr) {
            if ((x & bit) != 0) {
                a ^= x;
            }
            else {
                b ^= x;
            }
        }
        if (a < b) {
            return new int[] {a, b};
        }
        else {
            return new int[] {b, a};
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        System.out.println(Arrays.toString(find(arr)));
    }
}