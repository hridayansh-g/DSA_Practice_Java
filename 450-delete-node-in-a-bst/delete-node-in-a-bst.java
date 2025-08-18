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
        if (root == null) return null;
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            TreeNode succ = findMin(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }
        return root;
    }
    
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // approach 1
   /* public TreeNode deleteNode(TreeNode root, int key) {
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
    */
}