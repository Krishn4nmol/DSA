import java.util.*; // TC O(log(min(a,b))) SC O(1) for both lcm hcf
public class gcd {
    static int g(int n, int m) {
        while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }
    static int g1(int a, int b) {
        if (b == 0) return a;
        else return g1(b, a%b);  //Euclidean Algo gcd(a,b)=gcd(a-b,b)=gcd(b,a%b) for lcm use a*b/gcd
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.print(g1(n, m));
        }
    }
}