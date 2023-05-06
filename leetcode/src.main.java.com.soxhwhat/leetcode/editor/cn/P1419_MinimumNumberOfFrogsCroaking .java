package leetcode.editor.cn;

/**
 * 数青蛙
 * minimum-number-of-frogs-croaking
 * 2023-05-06 11:02:05
 *
 * @author soxhwhat
 */
class P1419_MinimumNumberOfFrogsCroaking {
    public static void main(String[] args) {
        Solution solution = new P1419_MinimumNumberOfFrogsCroaking().new Solution();
        solution.minNumberOfFrogs("crcoakroak");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int n = croakOfFrogs.length();
            if (n % 5 != 0) return -1;
            String s = "croak";
            int[] cnt = new int[5];
            int res = 0;
            int x = 0;
            int[] idx = new int[26];

            for (int i = 0; i < 5; i++) {
                idx[s.charAt(i) - 'a'] = i;
            }
            for (int i = 0; i < n; i++) {
                int k = idx[croakOfFrogs.charAt(i) - 'a'];
                ++ cnt[k];
                if (k == 0) {
                    res = Math.max(res, ++x);
                } else {
                    if (-- cnt[k - 1] < 0) {
                        return -1;
                    }
                    if (k == 4) {
                        -- x;
                    }
                }
            }
            return x > 0 ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}