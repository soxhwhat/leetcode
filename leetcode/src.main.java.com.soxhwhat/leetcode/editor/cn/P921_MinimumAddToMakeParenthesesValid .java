package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使括号有效的最少添加
 * minimum-add-to-make-parentheses-valid
 * 2022-10-04 22:51:14
 *
 * @author soxhwhat
 */
class P921_MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        Solution solution = new P921_MinimumAddToMakeParenthesesValid().new Solution();
        solution.minAddToMakeValid("((())");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAddToMakeValid(String s) {
            int socre = 0;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                socre += s.charAt(i) == '(' ? 1 : -1;
                if (socre < 0) {
                    socre = 0;
                    res ++;
                }
            }
            return res + socre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}