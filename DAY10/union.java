import java.util.*;
public class union {
    static ArrayList<Integer> union1(int arr[], int brr[]) { // TC O((n+m)log(n+m)) SC O(n+m)
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr)
            set.add(x);
        for (int y : brr)
            set.add(y);
        return new ArrayList<>(set);
    }
    static ArrayList<Integer> union2(int arr[], int brr[]) { // TC O(n+m) SC O(n+m)
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int m = brr.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr[i] < brr[j]) {
                if (list.isEmpty() || list.get(list.size()-1) != arr[i]) {
                    list.add(arr[i]);
                }
                i++;
            }
            else if (arr[i] > brr[j]) {
                if (list.isEmpty() || list.get(list.size()-1) != brr[j]) {
                    list.add(brr[j]);
                }
                j++;
            }
            else {
                if (list.isEmpty() || list.get(list.size()-1) != arr[i]) {
                    list.add(arr[i]);
                }
                i++; j++;
            }
        }
        while (i < n) {
            if (list.isEmpty() || list.get(list.size()-1) != arr[i]) {
                list.add(arr[i]);
            }
            i++;
        }
        while (j < m) {
            if (list.isEmpty() || list.get(list.size()-1) != brr[j]) {
                list.add(brr[j]);
            }
            j++;
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
        System.out.print(union1(arr, brr));
        System.out.println();
        System.out.print(union2(arr, brr));
    }
}