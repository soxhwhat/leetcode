package leetcode.editor.cn;

/**
 * 缺失的第一个正数
 * first-missing-positive
 * 2023-05-01 10:50:48
 *
 * @author soxhwhat
 */
class P41_FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new P41_FirstMissingPositive().new Solution();
        int res = solution.firstMissingPositive(new int[]{3, 4, -1, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) nums[i] = n + 1;
            }
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num <= n)
                    nums[num - 1] = -Math.abs(nums[num - 1]);
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) return i + 1;
            }
            return n + 1;
        }
//leetcode submit region end(Prohibit modification and deletion)
    }
}