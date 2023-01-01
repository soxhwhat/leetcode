package leetcode.editor.cn;

/**
 * 最长公共子序列
 * qJnOS7
 * 2022-12-13 17:16:39
 * @author soxhwhat
 */
class POfferII095_QJnOS7{
    public static void main(String[] args) {
        Solution solution = new POfferII095_QJnOS7().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] res = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) res[i][j] = res[i - 1][j - 1] + 1;
                else res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
            }
        }
        return res[n][m];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}