import java.util.*;
public class countfreqinarray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a[] = {0};
        for (int i = 0; i < n; i++) {
            a[arr[i]]++;
        }
        for (int i : a) {
            System.out.println(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
        LinkedHashMap<Integer, Integer> map1 = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            map1.put(arr[i], map1.getOrDefault(arr[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map2.put(arr[i], map2.getOrDefault(arr[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
} 