/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("#,");
                continue;
            }
            sb.append(cur.val).append(',');
            q.offer(cur.left);
            q.offer(cur.right);
        }
        sb.setLength(sb.length() - 1); // drop last comma
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] t = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(t[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;

        while (!q.isEmpty() && i < t.length) {
            TreeNode parent = q.poll();

            if (!t[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(t[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;

            if (i >= t.length) break;

            if (!t[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(t[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));