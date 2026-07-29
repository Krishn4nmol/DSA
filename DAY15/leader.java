import java.util.*;
public class leader {
    static ArrayList<Integer> find(int arr[]) { // TC O(n^2) SC O(1)
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader) list.add(arr[i]);
        }
        return list;
    }
    static ArrayList<Integer> find1(int arr[]) { // TC O(n) SC O(1)
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int max = arr[n - 1];
        list.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(find(arr));
        System.out.println(find1(arr));
    }
}