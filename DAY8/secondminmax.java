import java.util.*;

public class secondminmax { // TC O(n) SC O(1)

    static int[] find(int arr[]) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } 
            else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }

            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } 
            else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }

        return new int[]{secondSmallest, secondLargest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int result[] = find(arr);

        if (result[0] == Integer.MAX_VALUE)
            System.out.println("Second Smallest does not exist");
        else
            System.out.println("Second Smallest = " + result[0]);

        if (result[1] == Integer.MIN_VALUE)
            System.out.println("Second Largest does not exist");
        else
            System.out.println("Second Largest = " + result[1]);

        sc.close();
    }
}