package leetcode.editor.cn;

/**
 * 翻转子数组得到最大的数组值
 * reverse-subarray-to-Math.maximize-array-value
 * 2023-05-12 18:41:08
 * @author soxhwhat
 */
class P1330_ReverseSubarrayToMaximizeArrayValue{
    public static void main(String[] args) {
        Solution solution = new P1330_ReverseSubarrayToMaximizeArrayValue().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int tot = 0, res = 0;
        for (int i = 0; i < n - 1; i++)
            tot += Math.abs(nums[i] - nums[i + 1]);

        for (int i = 1; i < n; i++)
            res = Math.max(res, Math.abs(nums[0] - nums[i]) - Math.abs(nums[i - 1] - nums[i]));

        for (int i = 0; i < n - 1; i++)
            res = Math.max(res, Math.abs(nums[n - 1] - nums[i]) - Math.abs(nums[i + 1] - nums[i]));

        if (n <= 3)
            return tot + res;

        int x;
        x = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            int m = Math.min(nums[i], nums[i + 1]);
            if (m > x)
                res = Math.max(res, 2 * (m - x));
            x = Math.min(x, Math.max(nums[i - 1], nums[i]));

        }

        x = Math.max(nums[n - 1], nums[n - 2]);

        for (int i = n - 3; i >= 1; i--) {
            int m = Math.min(nums[i], nums[i - 1]);
            if (m > x)
                res = Math.max(res, 2 * (m - x));
            x = Math.min(x, Math.max(nums[i], nums[i + 1]));
        }

        return tot + res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}