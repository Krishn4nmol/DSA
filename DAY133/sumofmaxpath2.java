import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class sumofmaxpath2 { // TC O(n^2) SC O(h)
    static int maxGain(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));
        return root.val + Math.max(left, right);
    }
    static int maxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = maxGain(root.left);
        int right = maxGain(root.right);
        int current = root.val + Math.max(0, left)
                               + Math.max(0, right);
        int l = maxPathSum(root.left);
        int r = maxPathSum(root.right);
        return Math.max(current, Math.max(l, r));
    }
    static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            if (i < arr.length && !arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String arr[] = sc.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(arr);
        System.out.println(maxPathSum(root));
        sc.close();
    }
}
