package leetcode.editor.cn;

/**
 * 最大升序子数组和
 *
 * @author soxhwhat
 */
class P1800_MaximumAscendingSubarraySum{
    public static void main(String[] args) {
        Solution solution = new P1800_MaximumAscendingSubarraySum().new Solution();
        solution.maxAscendingSum(new int[]{3,6,10,1,8,9,9,8,9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > nums[i - 1]) {
                temp += nums[i];
            } else {
                max = Math.max(max, temp);
                temp = nums[i];
            }
        }
        return Math.max(max, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

