package leetcode.editor.cn;

/**
 * 掷骰子的N种方法
 *
 * @author soxhwhat
 */
class P1155_NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        Solution solution = new P1155_NumberOfDiceRollsWithTargetSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int) (1e9 + 7);

        public int numRollsToTarget(int n, int m, int t) {
            int max = n * m;
            if (t > max || t < n) {
                return 0;
            }
            int[][] dp = new int[2][t + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int a = i & 1, b = (i - 1) & 1;
                for (int j = 0; j <= t; j++) {
                    dp[a][j] = 0; // 先手动置零
                    for (int k = 1; k <= m; k++) {
                        if (j >= k) {
                            dp[a][j] = (dp[a][j] + dp[b][j - k]) % MOD;
                        }
                    }
                }
            }
            return dp[n & 1][t];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}