import java.util.*;
public class swap {
    static void swap1(int a, int b) { // TC O(1) SC O(1)
        int temp = a;
        a = b;
        b = temp;
    }
    static void swap2(int a, int b) { // TC O(1) SC O(1)
        a = a + b;
        b = a - b;
        a = a - b;
    }
    static void swap3(int a, int b) { // TC O(1) SC O(1)
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    static void swap4(int a, int b) { // TC O(1) SC O(1)
        b = a + b - (b = a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        swap1(a,b);
        //swap2(a,b);
        //swap3(a,b);
        //swap4(a,b);
        System.out.println(a + " " + b);
    }
}