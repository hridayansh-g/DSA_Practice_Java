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
import java.util.*;
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        inorder(root, a);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) <= a.get(i - 1)) return false; 
        }
        return true;
    }

    private void inorder(TreeNode node, List<Integer> a) {
        if (node == null) return;
        inorder(node.left, a);
        a.add(node.val);
        inorder(node.right, a);
    }
}