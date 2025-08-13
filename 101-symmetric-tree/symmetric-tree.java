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
}
}