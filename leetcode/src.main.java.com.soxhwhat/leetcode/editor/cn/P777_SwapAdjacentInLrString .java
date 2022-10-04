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
            if (start.length() != end.length()) {
                return false;
            }
            int length = start.length(), j = 0;
            char[] startArray = start.toCharArray();
            char[] endArray = end.toCharArray();
            for (int i = 0; i < length; i++) {
                if (start.charAt(i) == 'X') continue;
                for (; j < length; j++) {
                    if (end.charAt(j) != 'X') break;
                }
                if (j == length || startArray[i] != endArray[j]) return false;
                if (startArray[i] == 'L' && i < j) return false;// 'L'只能往左走
                if (startArray[i] == 'R' && i > j) return false;// 'R'只能往右走
                j++;
            }
            for (; j < length; j++)
                if (endArray[j] != 'X') return false;
            return true;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}