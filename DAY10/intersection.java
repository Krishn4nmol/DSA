import java.util.*;
public class intersection {
    static ArrayList<Integer> intersection1(int arr[], int brr[]) { // TC O(nm) SC O(m) + O(min(n,m))
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int m = brr.length;
        int visited[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i] == brr[j] && visited[j] == 0) {
                    list.add(arr[i]);
                    visited[j] = 1;
                    break;
                }
            }
        }
        return list;
    }
    static ArrayList<Integer> intersection2(int arr[], int brr[]) { // TC O(n+m) SC O(min(n,m))
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int m = brr.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr[i] == brr[j]) {
                list.add(arr[i]);
                i++; j++;
            }
            else if (arr[i] < brr[j]) i++;
            else j++;
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int brr[] = new int[m];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            brr[i] = sc.nextInt();
        System.out.print(intersection1(arr, brr));
        System.out.println();
        System.out.print(intersection2(arr, brr));
    }
}