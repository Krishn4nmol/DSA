import java.util.*;
public class countoverlapping { // TC O(nlogn) SC O(1)
    static int find(int arr[][]) {
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int count = 0;
        int last = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < last) {
                count++;
            }
            else {
                last = arr[i][1];
            }
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(find(arr));
        sc.close();
    }
}