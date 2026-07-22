import java.util.*;
public class dupinarray {
    static void dup1(int arr[]) { // TC O(n^2) SC O(n)
        int n = arr.length;
        int temp[] = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            boolean stored = false;
            for (int x = 0; x < k; x++) {
                if (arr[i] == temp[x]) {
                    stored = true;
                    break;
                }
            }
            if (stored) continue;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    temp[k] = arr[i];
                    k++;
                    break;
                }
            }
        }
        for (int y = 0; y < k; y++)
            System.out.print(temp[y] + " ");
    }
    static void dup2(int arr[]) { // TC O(n) SC O(n)
        int n = arr.length;
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> dup = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!seen.add(arr[i])) {
                dup.add(arr[i]);
            }
        }
        for (int x : dup) 
            System.out.print(x + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        dup1(arr);
        dup2(arr);
    }
}