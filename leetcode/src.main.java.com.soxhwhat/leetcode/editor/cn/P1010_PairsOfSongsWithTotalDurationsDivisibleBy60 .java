package leetcode.editor.cn;

/**
 * 总持续时间可被 60 整除的歌曲
 * pairs-of-songs-with-total-durations-divisible-by-60
 * 2023-05-07 21:28:49
 * @author soxhwhat
 */
class P1010_PairsOfSongsWithTotalDurationsDivisibleBy60{
    public static void main(String[] args) {
        Solution solution = new P1010_PairsOfSongsWithTotalDurationsDivisibleBy60().new Solution();
        solution.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int cnt[]  = new int[65];
        for (int i : time) {
            cnt[i % 60] ++;
        }
        int n = time.length;
        for (int i = 1; i < 30; i ++) {
            res += cnt[i] * cnt[60 - i];
        }
        res += (long) cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}