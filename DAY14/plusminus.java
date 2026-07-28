import java.util.*;
public class plusminus {
    static int[] solve(int arr[]) { // TC O(n) SC O(n)
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int x : arr) {
            if (x > 0) pos.add(x);
            else neg.add(x);
        }
        int p = 0, n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) arr[i] = pos.get(p++);
            else arr[i] = neg.get(n++);
        }
        return arr;
    }
    static int[] solve1(int arr[]) { // TC O(n) SC O(n)
        int n = arr.length;
        int temp[] = new int[n];
        int pos = 0;
        int neg = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                temp[pos] = arr[i];
                pos += 2;
            }
            else {
                temp[neg] = arr[i];
                neg += 2;
            }
        }
        return temp;
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
        System.out.println();
        int b[] = solve(arr);
        for (int x : b)
            System.out.print(x + " ");
    }
}