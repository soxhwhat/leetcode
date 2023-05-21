package leetcode.editor.cn;

/**
 * 二叉搜索子树的最大键值和
 * maximum-sum-bst-in-binary-tree
 * 2023-05-21 20:54:56
 * @author soxhwhat
 */
class P1373_MaximumSumBstInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P1373_MaximumSumBstInBinaryTree().new Solution();
        
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
        static final int MAX = 0x3f3f3f3f;
        int res;
        class BSTTree {
            boolean flag;
            int min;
            int max;
            int sum;

            BSTTree(boolean flag, int min, int max, int sum){
                this.flag = flag;
                this.min = min;
                this.max = max;
                this.sum = sum;
            }
        }
        public int maxSumBST(TreeNode root) {
            res = 0;
            dfs(root);
            return res;
        }

        public BSTTree dfs(TreeNode root) {
            if (root == null) return new BSTTree(true, MAX, -MAX, 0);

            BSTTree left = dfs(root.left);
            BSTTree right = dfs(root.right);

            if (left.flag && right.flag && root.val > left.max && root.val < right.min) {
                int sum = root.val + left.sum + right.sum;
                res = Math.max(res, sum);
                return new BSTTree(true, Math.min(left.min, root.val), Math.max(root.val, right.max), sum);
            } else return new BSTTree(false, 0, 0, 0);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}