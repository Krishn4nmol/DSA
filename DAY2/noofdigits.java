import java.util.*; // TC O(d)=O(logn) SC O(1)
public class noofdigits {
    static int d(int n) {
        int count = 0;
        int n1 = Math.abs(n);
        do {
            n1 = n1 / 10;
            count++;
        }
        while (n1 > 0);
        return count;
    }
    static int d1(int n) {  //not safe use do-while only
        int n1 = Math.abs(n);
        if (n == 0) return 1;
        int count = (int)(Math.log10(n1)+1);
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(d1(n));
        }
    }
}