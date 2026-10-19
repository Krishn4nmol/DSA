import java.util.*;
public class towerofhanoi { // TC O(2^n - 1) SC O(n)
    static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Minimum moves: " + ((1L << n) - 1));
        towerOfHanoi(n, 'A', 'B', 'C');
        sc.close();
    }
}