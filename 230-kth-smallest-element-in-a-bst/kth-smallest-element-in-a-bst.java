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

     public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !st.isEmpty()) {
            while (cur != null) {          
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();                 
            if (--k == 0) return cur.val;   
            cur = cur.right;               
        }
        return -1; 
    }
    // approach 1
  /*  public int kthSmallest(TreeNode root, int k) {
         List<Integer> a = new ArrayList<>();
        inorder(root, a);
        return a.get(k - 1);
    }

    private void inorder(TreeNode node, List<Integer> a) {
        if (node == null) return;
        inorder(node.left, a);
        a.add(node.val);
        inorder(node.right, a);
    }
    */

}