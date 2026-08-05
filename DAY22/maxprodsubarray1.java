import java.util.*;
public class maxprodsubarray1 {
    static void print(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int start = -1;
        int end = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= arr[j];
                if (prod > max) {
                    max = prod;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println(max);
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        print(arr);
    }
}