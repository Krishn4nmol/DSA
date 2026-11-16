import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class preordertraversal { // TC O(n) SC O(n)
    static List<Integer> preorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root, ans);
        return ans;
    }
    static void solve(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);       
        solve(root.left, ans);   
        solve(root.right, ans);  
    }
    static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1")) {
            return null;
        }
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
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String arr[] = sc.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(arr);
        List<Integer> ans = preorder(root);
        System.out.println(ans);
    }
}