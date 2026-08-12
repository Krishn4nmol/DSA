import java.util.*;
public class aggcows {
    static boolean canmake(int arr[], int k, int dist) {
        int cows = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                last = arr[i];
                cows++;
            }
            if (cows >= k) {
                return true;
            }
        }
        return false;
    }
    static int dist(int arr[], int k) { // TC O(nlogn+n*maxdist) SC O(1) maxdist = arr[n - 1] - arr[0];
        Arrays.sort(arr);
        int max = arr[arr.length - 1] - arr[0];
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            if (canmake(arr, k, i)) {
                ans = i;
            }
        }
        return ans;
    }
    static int dist1(int arr[], int k) { // TC O(nlogn+n*log(maxdist)) SC O(1)
        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canmake(arr, k, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(dist(arr, k));
        System.out.println(dist1(arr, k));
    }
}