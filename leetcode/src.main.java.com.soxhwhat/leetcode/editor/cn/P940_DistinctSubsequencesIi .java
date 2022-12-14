package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 不同的子序列 II
 * distinct-subsequences-ii
 * 2022-10-21 18:15:30
 * @author soxhwhat
 */
class P940_DistinctSubsequencesIi{
    public static void main(String[] args) {
        Solution solution = new P940_DistinctSubsequencesIi().new Solution();
        solution.distinctSubseqII("aaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distinctSubseqII(String s) {


        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        final int MOD = (int) (1e9 + 7);
        for (int i = 1; i <= n; i++) {
            int t = s.charAt(i - 1) - 'a';
            dp[i] = dp[i - 1] * 2 % MOD;
            if (last[t] >= 0) dp[i] -= dp[last[t]];
            dp[i] %= MOD;
            last[t] = i - 1;
        }
        dp[n]--;
        if (dp[n] < 0) dp[n] += MOD;
        return dp[n];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}