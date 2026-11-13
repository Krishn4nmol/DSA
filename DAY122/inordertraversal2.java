import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class inordertraversal2 { // TC O(n) SC O(n)
    static List<Integer> inorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
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
        List<Integer> ans = inorder(root);
        System.out.println(ans);
        sc.close();
    }
}