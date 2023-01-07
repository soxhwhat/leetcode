package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 将 x 减到 0 的最小操作数
 * minimum-operations-to-reduce-x-to-zero
 * 2023-01-07 21:32:24
 *
 * @author soxhwhat
 */
class P1658_MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        Solution solution = new P1658_MinimumOperationsToReduceXToZero().new Solution();
        solution.minOperations(new int[]{3,2,20,1,1,3}, 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();

            if (sum < x) {
                return -1;
            }

            int right = 0;
            int lsum = 0, rsum = sum;
            int ans = n + 1;
            /**
             * 由于数组 nums 中的元素均为正数，因此当 left 向右移动（即前缀的范围增加）时，它们的和是严格递增的。要想将它们的和控制在 x，我们必须要将 right 向右移动。这样一来，我们就可以用滑动窗口的方法解决本题。
             */
            for (int left = -1; left < n; ++left) {
                if (left != -1) {
                    lsum += nums[left];
                }
                while (right < n && lsum + rsum > x) {
                    rsum -= nums[right];
                    right++;
                }
                if (lsum + rsum == x) {
                    ans = Math.min(ans, n - (right - left - 1));
                }
            }
            return  ans > n ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}