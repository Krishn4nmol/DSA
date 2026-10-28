import java.util.*;
public class fruitbasket {
    static int totalFruit(int fruits[]) { // TC O(n) SC O(1)
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fruits[] = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }
        System.out.println(totalFruit(fruits));
        sc.close();
    }
}
