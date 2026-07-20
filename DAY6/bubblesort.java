import java.util.*; 
public class bubblesort { // TC O(n) BC O(n^2) AC, WC SC O(1)
    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean swap = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if (!swap) break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr);
        for (int x : arr) 
            System.out.print(x + " ");
    }
}