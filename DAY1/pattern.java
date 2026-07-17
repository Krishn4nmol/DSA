import java.util.*; //TC O(n^2) SC O(1)
public class pattern {
    static void p1 (int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if (i == 0 || i == n-1) {
                System.out.print("*");
               }
               else {
                if(j == 0 || j == n-1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
               }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            p1 (n);
        }   
    }
}