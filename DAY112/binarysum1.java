import java.util.*;
public class binarysum1 { // TC O(n) SC O(1)
    public static int atMost(int nums[], int goal) {
        if (goal < 0) return 0;
        int left = 0;
        int sum = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
    static int numSubarraysWithSum(int nums[], int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int goal = sc.nextInt();
        int ans = numSubarraysWithSum(nums, goal);
        System.out.println(ans);
        sc.close();
    }
}