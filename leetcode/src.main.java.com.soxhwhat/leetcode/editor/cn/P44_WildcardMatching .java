package leetcode.editor.cn;

/**
 * 通配符匹配
 * wildcard-matching
 * 2023-01-20 00:47:29
 *
 * @author soxhwhat
 */
class P44_WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new P44_WildcardMatching().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int n = s.length(), m = p.length();
            s = " " + s;
            p = " " + p;
            boolean[][] f = new boolean[n + 10][m + 10];
            f[0][0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i > 0 && p.charAt(j) != '*') {
                        f[i][j] = f[i - 1][j -1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                    } else if (p.charAt(j) == '*'){
                        f[i][j] = f[i][j - 1] || (i > 0 && f[i - 1][j]);
                    }
                }
            }
            return f[n][m];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}