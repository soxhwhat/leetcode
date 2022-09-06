package leetcode.editor.cn;


/**
 * 最长同值路径
 *
 * @author soxhwhat
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class P687_LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new P687_LongestUnivaluePath().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * <p>
     * }
     */
    class Solution {
        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return max;

        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int l = dfs(root.left), r = dfs(root.right);
            if (root.left != null && root.val == root.left.val) l++;
            else l = 0;

            if (root.right != null && root.val == root.right.val) r++;
            else r = 0;
            max = Math.max(max, l + r);
            return Math.max(r, l);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

