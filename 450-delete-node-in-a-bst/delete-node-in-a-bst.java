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
    public TreeNode deleteNode(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        if (!list.contains(key)) return root; 
        list.remove(Integer.valueOf(key));
        
        return buildBST(list, 0, list.size() - 1);
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    
    private TreeNode buildBST(List<Integer> list, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBST(list, l, mid - 1);
        root.right = buildBST(list, mid + 1, r);
        return root;
    }
}