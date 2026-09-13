import java.util.*;
public class mcolor { // TC O(m^V * V) SC O(V)
    static boolean isSafe(int vertex, int graph[][], int n, int color[], int c) {
        for (int i = 0; i < n; i++) {
            if (graph[vertex][i] == 1 && color[i] == c) {
                return false
            }
        }
        return true;
    }
    static boolean solve(int vertex, int graph[][], int n, int color[], int m) {
        if (vertex == n) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isSafe(vertex, graph, n, color, c)) {
                color[vertex] = c;
                if (solve(vertex + 1, graph, n, color, m)) {
                    return true;
                }
                color[vertex] = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int graph[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();
        int m = sc.nextInt();
        int color[] = new int[n];
        if (solve(0, graph, n, color, m)) {
            for (int i = 0; i < n; i++)
                System.out.println(i + "->" + color[i]);
        }
        else {
            System.out.println("Error");
        }
    }
}