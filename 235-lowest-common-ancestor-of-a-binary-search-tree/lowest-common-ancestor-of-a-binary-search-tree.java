/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> a = new ArrayList<>(), b = new ArrayList<>();
        path(root, p, a);
        path(root, q, b);
        int i = 0, m = Math.min(a.size(), b.size());
        TreeNode ans = null;
        while (i < m && a.get(i) == b.get(i)) {
            ans = a.get(i);
            i++;
        }
        return ans;
    }

    private boolean path(TreeNode node, TreeNode target, List<TreeNode> out) {
        if (node == null) return false;
        out.add(node);
        if (node == target) return true;
        if (path(node.left, target, out) || path(node.right, target, out)) return true;
        out.remove(out.size() - 1);
        return false;
    }
}