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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        helper(root, li);
        return li;
    }
    
    private void helper(TreeNode root, List<Integer> li) {
        if (root == null) {
            return;
        }
        helper(root.left, li);       // Left
        li.add(root.val);            // Root
        helper(root.right, li);      // Right
    }
}