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

    private int pre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = 0;
        return build(preorder, inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preArr, int[] inArr, int L, int R) {
        if (L > R) return null;
        int val = preArr[pre++];
        TreeNode root = new TreeNode(val);

        int mid = L;
        while (mid <= R && inArr[mid] != val) mid++; 

        root.left  = build(preArr, inArr, L, mid - 1);
        root.right = build(preArr, inArr, mid + 1, R);
        return root;
    }
}