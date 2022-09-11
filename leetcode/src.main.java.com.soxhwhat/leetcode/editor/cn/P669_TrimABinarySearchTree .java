package leetcode.editor.cn;

/**
 * 修剪二叉搜索树
 *
 * @author soxhwhat
 */
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

class P669_TrimABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P669_TrimABinarySearchTree().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if(root == null) return null;
            if(root.val < low) return trimBST(root.right, low, high);
            else if(root.val > high) return trimBST(root.left, low, high);

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

