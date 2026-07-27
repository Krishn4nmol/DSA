import java.util.*;
public class majoritynby3 {
    static void find1(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            boolean seen = false;
            for (int k = 0; k < i; k++) {
                if (arr[k] == arr[i]) {
                    seen = true;
                    break;
                }
            }
            if (seen) continue;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) count++;
            }
            if (count > n/3) {
                System.out.println(arr[i]);
                flag = true;
            }
        }
        if (!flag) System.out.println("Not found");
    }
    static void find2(int arr[]) { // TC O(n) SC O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        boolean flag = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > arr.length / 3) {
                System.out.println(entry.getKey());
                flag = true;
            }
        }
        if (!flag) System.out.println("Not found");
    }
    static void find3(int arr[]) { // TC O(n) SC O(1) MOORE'S VOTING ALGO
        int n = arr.length;
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;
        for (int x : arr) {
            if (candidate1 == x) {
                count1++;
            }
            else if (candidate2 == x) {
                count2++;
            }
            else if (count1 == 0) {
                count1 = 1;
                candidate1 = x;
            }
            else if (count2 == 0) {
                count2 = 1;
                candidate2 = x;
            }
            else {
                count1--;
                count2--;
            }
        }
        int count3 = 0, count4 = 0;
        for (int x : arr) {
            if (candidate1 == x) count3++;
            else if (candidate2 == x) count4++;
        }
        boolean flag = false;
        if (count3 > n/3) {
            System.out.println(candidate1); 
            flag = true;
        }
        if (count4 > n/3) {
            System.out.println(candidate2);
            flag = true;
        }
        if (!flag) System.out.println("Not found");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        find1(arr);
        find2(arr);
        find3(arr);
    }
}