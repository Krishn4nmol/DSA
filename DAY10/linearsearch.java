import java.util.*;
public class linearsearch {
    static void search1(int arr[], int key) { // TC O(n) SC O(1)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.print("Element found at index " + i);
                return;
            }
        }
        System.out.print("Element not found");
    }
    static void search2(int arr[], int key, int i) { // TC O(n) SC O(n)
        if (i == arr.length) {
            System.out.print("ELement not found");
            return;
        }
        if (arr[i] == key) {
            System.out.print("Element found at index " + i);
            return;
        }
        search2(arr, key, i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        int key = sc.nextInt();
        search1(arr, key);
        System.out.println();
        search2(arr, key, 0);
    }
}