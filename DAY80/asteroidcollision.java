import java.util.*;
public class asteroidcollision { // TC O(n) SC O(n)
    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                if (st.peek() < -asteroid) {
                    st.pop();
                } else if (st.peek() == -asteroid) {
                    st.pop();
                    asteroid = 0;
                } else {
                    asteroid = 0;
                }
            }
            if (asteroid != 0) {
                st.push(asteroid);
            }
        }
        int ans[] = new int[st.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = st.get(i);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int asteroids[] = new int[n];
        for (int i = 0; i < n; i++) {
            asteroids[i] = sc.nextInt();
        }
        int ans[] = asteroidCollision(asteroids);
        System.out.print("[");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            if (i < ans.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}