/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            if (a == null && b == null) continue;
            if (a == null || b == null || a.val != b.val) return false;
            q.offer(a.left);  q.offer(b.right);
            q.offer(a.right); q.offer(b.left);
        }
        return true;
    }

    // approach 2
    /*
     public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;      
        if (a.val != b.val) return false;
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
    */

    // approach 1
  /*  public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode mir = mirrorClone(root);     
        return equal(root, mir);             
    }

    private TreeNode mirrorClone(TreeNode node) {
        if (node == null) return null;
        TreeNode m = new TreeNode(node.val);
        m.left  = mirrorClone(node.right);
        m.right = mirrorClone(node.left);
        return m;
    }

    private boolean equal(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        if (a.val != b.val) return false;
        return equal(a.left, b.left) && equal(a.right, b.right);
} */
}