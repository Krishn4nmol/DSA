import java.util.*;
public class goodsubarray { // TC O(n) SC O(n)
    static int atMost(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0;
        
        return count;
    }
    static int subarraysWithKDistinct(int nums[], int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarraysWithKDistinct(nums, k));
        sc.close();
    }
}