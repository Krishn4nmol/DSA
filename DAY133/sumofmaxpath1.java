import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class sumofmaxpath1 { // TC O(n) SC O(h)
    int maxSum = Integer.MIN_VALUE;
    int maxGain(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));
        maxSum = Math.max(maxSum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
    int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
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
        sumofmaxpath1 obj = new sumofmaxpath1();
        System.out.println(obj.maxPathSum(root));
        sc.close();
    }
}
