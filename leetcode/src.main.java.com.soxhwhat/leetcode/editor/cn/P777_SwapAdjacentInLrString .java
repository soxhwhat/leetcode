package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 在LR字符串中交换相邻字符
 * swap-adjacent-in-lr-string
 * 2022-10-02 22:30:42
 *
 * @author soxhwhat
 */
class P777_SwapAdjacentInLrString {
    public static void main(String[] args) {
        Solution solution = new P777_SwapAdjacentInLrString().new Solution();
        solution.canTransform("LXXLXRLXXL", "XLLXRXLXLX");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canTransform(String start, String end) {
            int n = start.length();
            int i = 0, j = 0;
            while (i < n || j < n) {
                while (i < n && start.charAt(i) == 'X') i ++;
                while (j < n && end.charAt(j) == 'X') j ++;
                if (i == n || j == n) return i == j;
                if (start.charAt(i) != end.charAt(j)) return false;
                if (start.charAt(i) == 'R' && i > j) return false;
                if (start.charAt(i) == 'L' && i < j) return false;
                i ++;
                j ++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}