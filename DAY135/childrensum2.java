import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class childrensum2 { // TC O(n) SC O(n)
    static boolean isSumProperty(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left == null && curr.right == null)
                continue;
            int left = (curr.left == null) ? 0 : curr.left.val;
            int right = (curr.right == null) ? 0 : curr.right.val;
            if (curr.val != left + right)
                return false;
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return true;
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
        System.out.println(isSumProperty(root));
        sc.close();
    }
}
