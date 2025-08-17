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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left  = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
       // return mirrorCopy(root);
    }
    // approach 1
    /* private TreeNode mirrorCopy(TreeNode node) {
        if (node == null) return null;
        TreeNode res = new TreeNode(node.val);
        res.left  = mirrorCopy(node.right);
        res.right = mirrorCopy(node.left);
        return res;
    }
    */
}