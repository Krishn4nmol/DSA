import java.util.*; // TC O(root n) SC O(1)
public class checkprime {
    static void p(int n) {
        boolean flag = false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag || n < 2) System.out.print("Not prime");
        else System.out.print("Prime"); 
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