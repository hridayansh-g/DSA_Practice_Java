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
    public List<Integer> postorderTraversal(TreeNode node) {
        List<Integer> li= new ArrayList<>();
        if(node== null){
            return li;
        }

        li.addAll(postorderTraversal(node.left));
        li.addAll(postorderTraversal(node.right));
        li.add(node.val);
        return li;
        
    }
}