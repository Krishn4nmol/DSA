import java.util.*;
public class nextpermutation { // TC O(n) SC O(1) for brute force find all permutations, sort them lexicographically, pick the current one and return the next one TC O(nxn!) SC O(nxn!)
    static void reverse(int arr[], int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    static void next(int arr[]) {
        int n = arr.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i+1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(arr, 0, n-1);
            return;
        }
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        reverse(arr, index + 1, n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        next(arr);
        for (int x : arr)
            System.out.print(x + " ");
    }
}