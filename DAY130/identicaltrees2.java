import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class identicaltrees2 { // TC O(n) SC O(n
    static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode a = q1.poll();
            TreeNode b = q2.poll();
            if (a == null && b == null)
                continue;
            if (a == null || b == null)
                return false;
            if (a.val != b.val)
                return false;
            q1.add(a.left);
            q1.add(a.right);
            q2.add(b.left);
            q2.add(b.right);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
    static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            if (i < arr.length && !arr[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr1[] = sc.nextLine().trim().split("\\s+");
        String arr2[] = sc.nextLine().trim().split("\\s+");
        TreeNode p = buildTree(arr1);
        TreeNode q = buildTree(arr2);
        System.out.println(isSameTree(p, q));
        sc.close();
    }
}
