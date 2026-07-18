import java.util.*;
public class revarray {
    static void rev1(int arr[], int n) { // TC O(n) SC O(n)
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }
        Collections.reverse(list);
        for (int x : list) {
            System.out.print(x + " ");
        }
    }
    static void rev2(int arr[], int n) { // TC O(n) SC O(1)
        int left = 0;
        int right = n-1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    static void rev3(int arr[], int n, int i) { // TC O(n) SC O(n)
        if (i >= n/2) return; 
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        rev3(arr, n, i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        rev3(arr, n, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}