package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 与对应负数同时存在的最大正整数
 * largest-positive-integer-that-exists-with-its-negative
 * 2023-05-13 22:24:51
 *
 * @author soxhwhat
 */
class P2441_LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        Solution solution = new P2441_LargestPositiveIntegerThatExistsWithItsNegative().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public static final int MAX = 1000;

        public int findMaxK(int[] nums) {
            int n = nums.length;
            int[] cnt = new int[MAX + 1];
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) cnt[nums[i]] |= 1;
                else cnt[-nums[i]] |= 2;
            }
            for (int i = MAX; i >= 0; i--) {
                if (cnt[i] == 3) {
                    return i;
                }
            }
            return -1;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}