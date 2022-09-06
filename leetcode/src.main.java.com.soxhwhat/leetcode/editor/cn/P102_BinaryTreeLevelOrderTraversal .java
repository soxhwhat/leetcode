package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author soxhwhat
 */
class P102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();

            if(root != null) queue.add(root);

            while (!queue.isEmpty()) {
                int n = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.peek();
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);

                    list.add(node.val);
                    queue.poll();
                }
                ans.add(list);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

