package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 按列翻转得到最大值等行数
 * flip-columns-for-maximum-number-of-equal-rows
 * 2023-05-15 17:07:14
 * @author soxhwhat
 */
class P1072_FlipColumnsForMaximumNumberOfEqualRows{
    public static void main(String[] args) {
        Solution solution = new P1072_FlipColumnsForMaximumNumberOfEqualRows().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        var map = new HashMap<String, Integer>();
        int res = 0, n = matrix[0].length;
        for (var row : matrix) {
            var cs = new char[n];
            for (int i = 0; i < n; i++) {
                // 此处运算非常巧妙，把同价类合并到同一个集合中
                cs[i] = (char) (row[0] ^ row[i]);
            }
            res = Math.max(res, map.merge(String.valueOf(cs), 1, Integer::sum));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}