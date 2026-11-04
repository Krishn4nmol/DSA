import java.util.*;
public class nicesubarray { // TC O(n) SC O(1)
    static int atMost(int nums[], int k) {
        int left = 0;
        int count = 0;
        int odd = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                odd++;
            }
            while (odd > k) {
                if (nums[left] % 2 != 0) {
                    odd--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
    static int numberOfSubarrays(int nums[], int k) {
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
        System.out.println(numberOfSubarrays(nums, k));
        sc.close();
    }
}
