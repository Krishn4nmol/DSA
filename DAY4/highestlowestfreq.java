import java.util.*;
public class highestlowestfreq {
    static void print(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int maxfreq = Integer.MIN_VALUE;
        int minfreq = Integer.MAX_VALUE;
        int max = 0;
        int min = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxfreq) {
                maxfreq = entry.getValue();
                max = entry.getKey();
            }
            if (entry.getValue() < minfreq) {
                minfreq = entry.getValue();
                min = entry.getKey();
            }
        }
        System.out.println("Min element: " + min + " Freq: " + minfreq);
        System.out.println("Max element: " + max + " Freq: " + maxfreq);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        print(arr, n);
    }
}