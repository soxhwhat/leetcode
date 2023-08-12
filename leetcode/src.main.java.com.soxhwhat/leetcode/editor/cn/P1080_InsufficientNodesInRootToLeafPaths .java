package leetcode.editor.cn;

/**
 * 根到叶路径上的不足节点
 * insufficient-nodes-in-root-to-leaf-paths
 * 2023-05-23 22:25:51
 * @author soxhwhat
 */
class P1080_InsufficientNodesInRootToLeafPaths{
    public static void main(String[] args) {
        Solution solution = new P1080_InsufficientNodesInRootToLeafPaths().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
        int LIMIT;
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            LIMIT = limit;
            boolean flag = dfs(root, 0);
            return flag ? root : null;
        }

        private boolean dfs(TreeNode root, int sum) {
            if (root == null) return false;
            int temp = sum + root.val;
            if (root.left == null && root.right == null) return  temp >= LIMIT;

            boolean leftFlag= dfs(root.left, temp);
            boolean rightFlag = dfs(root.right, temp);

            if (!leftFlag) root.left = null;
            if (!rightFlag) root.right = null;

            return leftFlag || rightFlag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}