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
            int cur = 0;
            int res = 0;
            for (int i = 0; i < s.toCharArray().length; i++) {
                if (s.charAt(i) == '(') cur ++;
                else {
                    cur --;
                    if (s.charAt(i - 1) == '(') res += 1 << cur;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

