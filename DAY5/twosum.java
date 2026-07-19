import java.util.*;
public class twosum {
    static int[] check(int arr[], int target) { // TC O(n^2) SC O(1)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target)
                    return new int[] {i, j};
            }
        }
        return new int[] {};
    }
    static void check1(int arr[], int target) { // TC O(n) SC O(n)
        boolean flag = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp))
                // return new int[] {map.get(comp), i};
                System.out.println(map.get(comp) + " " + i);
                flag = true;
            map.put(arr[i], i);
        }
        if (!flag) System.out.println("No two sum exists");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int t = sc.nextInt();
        int a[] = check(arr, t);
        if (a.length == 0) {
            System.out.println("No two sum exist");
        }
        else {
            System.out.println(a[0] + " " + a[1]);
        }
        check1(arr, t);
    }
}