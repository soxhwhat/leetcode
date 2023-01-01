package leetcode.editor.cn;

/**
 * 最长连续递增序列
 * longest-continuous-increasing-subsequence
 * 2022-12-13 17:39:14
 * @author soxhwhat
 */
class P674_LongestContinuousIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new P674_LongestContinuousIncreasingSubsequence().new Solution();
        int[] nums = {1, 3, 5, 4, 7};
        solution.findLengthOfLCIS(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int n = nums.length;
        for (int i = 1, j = 0; i < n; i ++) {
            while (i < n && nums[i] > nums[i - 1]) i ++;
            res = Math.max(res, i - j);
            j = i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}