import java.util.*;
public class candy {
    static int find(int rating[]) { // TC O(n) SC O(n)
        int n = rating.length;
        int candies[] = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (rating[i] > rating[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (rating[i] > rating[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rating[] = new int[n];
        for (int i = 0; i < n; i++) 
            rating[i] = sc.nextInt();
        System.out.println(find(rating));
        sc.close();
    }
}