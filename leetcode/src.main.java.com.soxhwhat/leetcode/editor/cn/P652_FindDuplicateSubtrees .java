package leetcode.editor.cn;

import java.util.*;

/**
 * 寻找重复的子树
 *
 * @author soxhwhat
 */
class P652_FindDuplicateSubtrees{
    public static void main(String[] args) {
        Solution solution = new P652_FindDuplicateSubtrees().new Solution();
        
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
    HashMap<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> list = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(list);
    }

    private String dfs(TreeNode root) {
        if(root == null) return "";
        StringBuilder builder = new StringBuilder();
        builder.append(root.val);

        builder.append("(");
        builder.append(dfs(root.left));
        builder.append(")(");
        builder.append(dfs(root.right));
        builder.append(")");
        String s = builder.toString();
        if(map.containsKey(s)){
            list.add(map.get(s));
        }else{
            map.put(s, root);
        }
        return s;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

