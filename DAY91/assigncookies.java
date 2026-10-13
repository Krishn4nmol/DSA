import java.util.*;
public class assigncookies {
    static int find(int student[], int cookie[]) { // TC O(nlogn + mlogm) SC O(1)
        Arrays.sort(student);
        Arrays.sort(cookie);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < student.length && j < cookie.length) {
            if (cookie[j] >= student[i]) {
                i++;
                j++;
                count++;
            }
            else {
                j++;
            }
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int student[] = new int[n];
        for (int i = 0; i < n; i++)
            student[i] = sc.nextInt();
        int m = sc.nextInt();
        int cookie[] = new int[m];
        for (int i = 0; i < m; i++)
            cookie[i] = sc.nextInt();
        System.out.println(find(student, cookie));
        sc.close();
    }
}