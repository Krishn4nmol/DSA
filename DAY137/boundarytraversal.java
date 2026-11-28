import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class boundarytraversal { // TC O(n) SC O(h)
    static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    static void leftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr))
                ans.add(curr.val);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    static void leaves(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (isLeaf(root)) {
            ans.add(root.val);
            return;
        }
        leaves(root.left, ans);
        leaves(root.right, ans);
    }
    static void rightBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr))
                temp.add(curr.val);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--)
            ans.add(temp.get(i));
    }
    static List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        if (isLeaf(root)) {
            ans.add(root.val);
            return ans;
        }
        ans.add(root.val);
        leftBoundary(root, ans);
        leaves(root, ans);
        rightBoundary(root, ans);
        return ans;
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
        List<Integer> ans = boundary(root);
        System.out.println(ans);
        sc.close();
    }
}