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
     // Approach 1
     /*
     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String sRoot = serialize(root, new StringBuilder()).toString();
        String sSub  = serialize(subRoot, new StringBuilder()).toString();
        return kmpContains(sRoot, sSub);
    }

   
    private StringBuilder serialize(TreeNode node, StringBuilder sb) {
        if (node == null) return sb.append("#,");   // # marks null
        sb.append('(').append(node.val).append("),");
        serialize(node.left, sb);
        serialize(node.right, sb);
        return sb;
    }

    
    private boolean kmpContains(String text, String pat) {
        if (pat.length() == 0) return true;
        int[] lps = buildLps(pat);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pat.charAt(j)) {
                i++; j++;
                if (j == pat.length()) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return false;
    }

    private int[] buildLps(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0;
        for (int i = 1; i < pat.length(); ) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
    */


   
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;   // empty subRoot -> always true
        if (root == null) return false;

        if (same(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean same(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        if (a.val != b.val) return false;
        return same(a.left, b.left) && same(a.right, b.right);
    }
    
}