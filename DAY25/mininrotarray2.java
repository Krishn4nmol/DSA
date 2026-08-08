import java.util.*;
public class mininrotarray2 {
    static int print(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == arr[high]) {
                high--;
            }
            else if (arr[mid] > arr[high]) {
                low = mid + 1;   // for max high = mid;
            }
            else {
                high = mid; // for max low = mid + 1;
            }
        }
        return arr[low];    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        System.out.println(print(arr));
    }
}