package leetcode.editor.cn;

/**
 * 括号的分数
 *
 * @author soxhwhat
 */
class P856_ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new P856_ScoreOfParentheses().new Solution();
        solution.scoreOfParentheses("(()(()))");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            int res = 0;
            int cur = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') cur ++;
                else {
                    cur --;
                    if (chars[i - 1] == '(') res += 1 << cur;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

