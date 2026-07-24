import java.util.*;
public class missing {
    static int find(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        for (int i = 1; i <= n + 1; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1;
    }
    static int find1(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length + 1;
        int expected = n * (n+1) / 2;
        int actual = 0;
        for (int x : arr)
            actual += x;
        return expected-actual;
    }
    static int find2(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length + 1;
        int xor1 = 0;
        for (int i = 1; i <= n; i++)
            xor1 ^= i;
        int xor2 = 0;
        for (int x : arr)
            xor2 ^= x;
        return xor1^xor2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        System.out.println(find(arr));
        System.out.println(find1(arr));
        System.out.println(find2(arr));
    }
}