import java.util.*; // TC O(root n) SC O(1) here O(root n) because using list to store
public class divisors {
    static void p(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i)
                    list.add(n/i);
            }
        }
        Collections.sort(list);
        for (int x : list)
            System.out.print(x + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            p(n);
        }
    }
}