import java.util.*;
public class longestconsecutive {
    static boolean search(int arr[], int x) {
        for (int i : arr) {
            if (i == x) return true;
        }
        return false;
    }
    static void find(int arr[]) { // TC O(n^3) SC O(1)
        int n = arr.length;
        int longest = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int count = 1;
            while (search(arr, x+1)) {
                x++;
                count++;
            }
            if (count > longest) {
                longest = count;
                start = arr[i];
            }
        }
        System.out.println(longest);
        for (int i = start; i < start + longest; i++) {
            System.out.print(i + " ");
        }
    }
    static void find1(int arr[]) { // TC O(nlogn) SC O(1)
        int n = arr.length;
        if (n == 0) return;
        Arrays.sort(arr);
        int longest = 1;
        int min = arr[0];
        int count = 1;
        int temp = arr[0];
        int curr = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == min + 1) {
                count++;
                min = arr[i];
            }
            else if (arr[i] != min) {
                count = 1;
                min = arr[i];
                curr = arr[i];
            }
            if (count > longest) {
                longest = count;
                temp = curr;
            }
        }
        System.out.println(longest);
        for (int i = temp; i < temp + longest; i++) {
            System.out.print(i + " ");
        }
    }
    static void find2(int arr[]) { // TC O(n) SC O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        int longest = 0;
        int start = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int count = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                if (count > longest) {
                    longest = count;
                    start = num;
                }
            }
        }
        System.out.println(longest);
        for (int i = start; i < start + longest; i++) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        find(arr);
        System.out.println();
        find1(arr);
        System.out.println();
        find2(arr);
    }
}