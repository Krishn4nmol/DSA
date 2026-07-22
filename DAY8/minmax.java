import java.util.*;

public class minmax { // TC O(n) SC O(1)

    static int[] find(int arr[]) {
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];

            if (arr[i] < min)
                min = arr[i];
        }

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int result[] = find(arr);

        System.out.println("Minimum = " + result[0]);
        System.out.println("Maximum = " + result[1]);

        sc.close();
    }
}