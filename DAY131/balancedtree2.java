import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class balancedtree2 { // TC O(n^2) SC O(h)
    static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left),
                            height(root.right));
    }
    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            return false;
        return isBalanced(root.left) &&
               isBalanced(root.right);
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
        String arr[] = sc.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(arr);
        System.out.println(isBalanced(root) ? "Yes" : "No");
        sc.close();
    }
}
