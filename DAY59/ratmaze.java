import java.util.*;
public class ratmaze { // TC O(4^(n^2)) SC O(n^2)
    static void ratmaz(int row, int col, int arr[][], int n, int visited[][], String path, List<String> ans) {
        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }
        int dr[] = {1,0,0,-1};
        int dc[] = {0,-1,1,0};
        char dir[] = {'D','L','R','U'};
        for (int i = 0; i < 4; i++) {
            int newrow = row + dr[i];
            int newcol = col + dc[i];
            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n && arr[newrow][newcol] == 1 && visited[newrow][newcol] == 0) {
                visited[newrow][newcol] = 1;
                String newpath = path + dir[i];
                ratmaz(newrow,newcol,arr,n,visited,newpath,ans); // dfs
                visited[newrow][newcol] = 0; // backtrack
            }
        }
    }
    static List<String> rat(int arr[][]) {
        List<String> ans = new ArrayList<>();
        int n = arr.length;
        if (arr[0][0] == 0 || arr[n-1][n-1] == 0) return ans;
        int visited[][] = new int[n][n];
        visited[0][0] = 1;
        ratmaz(0,0,arr,n,visited,"",ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        List<String> ans = rat(arr);
        for (String temp : ans) {
            System.out.println(temp);
        }
    }
}