package leetcode.editor.cn;

/**
 * 正则表达式匹配
 * regular-expression-matching
 * 2023-01-18 21:27:44
 *
 * @author soxhwhat
 */
class P10_RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new P10_RegularExpressionMatching().new Solution();
        solution.isMatch("aa", "a");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int n = s.length();
            int m = p.length();
            s = " " + s;
            p = " " + p;
            boolean[][] f = new boolean[n + 10][m + 10];
            f[0][0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j + 1 <= m && p.charAt(j + 1) == '*') continue;//当前位应该和下一位看作整体
                    if (p.charAt(j) != '*') {
                        boolean flag = (p.charAt(j) == s.charAt(i)) || (p.charAt(j) == '.');
                        f[i][j] = i != 0 && f[i - 1][j - 1] && flag;
                    } else {
                        boolean flag = (p.charAt(j - 1) == s.charAt(i)) || (p.charAt(j - 1) == '.');
                        f[i][j] = f[i][j - 2] || (i != 0 && f[i - 1][j] && flag);
                    }
                }
            }
            return f[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}