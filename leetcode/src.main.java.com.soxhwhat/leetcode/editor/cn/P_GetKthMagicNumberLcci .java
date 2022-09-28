package leetcode.editor.cn;

/**
 * 第 k 个数
 *
 * @author soxhwhat
 */
class P_GetKthMagicNumberLcci {
    public static void main(String[] args) {
        Solution solution = new P_GetKthMagicNumberLcci().new Solution();
        solution.getKthMagicNumber(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] dp = new int[k];
            int d3 = 0, d5 = 0, d7 = 0;
            dp[0] = 1;
            for (int i = 1; i < k; i++) {
                dp[i] = Math.min(Math.min(dp[d3] * 3, dp[d5] * 5), dp[d7] * 7);
                if (dp[i] == dp[d3] * 3) d3++;
                if (dp[i] == dp[d5] * 5) d5++;
                if (dp[i] == dp[d7] * 7) d7++;
            }
            return dp[k - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}