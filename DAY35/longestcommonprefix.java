import java.util.*;
public class longestcommonprefix {
    static String find(String arr[]) { // TC O(n*m) SC O(m)
        String first = arr[0];
        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            for (int j = 1; j < arr.length; j++) {
                if (i >= arr[j].length() || arr[j].charAt(i) != ch) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.next();
        System.out.println(find(arr));
    }
}