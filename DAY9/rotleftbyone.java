import java.util.*;
public class rotleftbyone {
    static void rotate(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        rotate(arr);
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " ");
    }
}