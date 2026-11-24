import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class sumofmaxpath3 { // TC O(n) SC O(n)
    static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.peek();
            if (curr.left != null && !map.containsKey(curr.left)) {
                st.push(curr.left);
            }
            else if (curr.right != null && !map.containsKey(curr.right)) {
                st.push(curr.right);
            }
            else {
                st.pop();
                int left = (curr.left == null) ? 0 :
                           Math.max(0, map.get(curr.left));
                int right = (curr.right == null) ? 0 :
                            Math.max(0, map.get(curr.right));
                int current = curr.val + left + right;
                maxSum = Math.max(maxSum, current);
                map.put(curr, curr.val + Math.max(left, right));
            }
        }
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
        System.out.println(maxPathSum(root));
        sc.close();
    }
}
