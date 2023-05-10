package leetcode.editor.cn;

/**
 * 有效时间的数目
 * number-of-valid-clock-times
 * 2023-05-10 10:36:27
 *
 * @author soxhwhat
 */
class P2437_NumberOfValidClockTimes {
    public static void main(String[] args) {
        Solution solution = new P2437_NumberOfValidClockTimes().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        public int countTime(String times) {
            char[] time = times.toCharArray();
            dfs(time, 0);
            return res;

        }
        public void dfs(char[] time, int u) {
            if (u == time.length) {
                if (check(time)) res ++;
                return;
            }
            if (time[u] == '?') {
                for (char i = '0'; i <= '9'; i++) {
                    time[u] = i;
                    dfs(time, u + 1);
                    time[u] = '?';
                }
            } else {
                dfs(time, u + 1);
            }

        }
        public boolean check(char[] time) {
            int h = (time[0] - '0') * 10 + (time[1] - '0');
            int m = (time[3] - '0') * 10 + (time[4] - '0');
            return h >= 0 && h < 24 && m >= 0 && m < 60;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}