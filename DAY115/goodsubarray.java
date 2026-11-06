import java.util.*;
public class goodsubarray { // TC O(n) SC O(n)
    static int atMost(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
        }
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