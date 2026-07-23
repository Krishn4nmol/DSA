import java.util.*;
public class removedupinsorted {
    static int remove(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        if (n == 0) return 0;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = remove(arr);
        for (int i = 0; i < k; i++) 
            System.out.print(arr[i] + " ");
    }
}