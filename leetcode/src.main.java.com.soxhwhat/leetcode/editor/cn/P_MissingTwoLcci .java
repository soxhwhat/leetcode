package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 消失的两个数字
 *
 * @author soxhwhat
 */
class P_MissingTwoLcci {
    public static void main(String[] args) {
        Solution solution = new P_MissingTwoLcci().new Solution();
        solution.missingTwo(new int[]{2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            int n = nums.length + 2;
            int type1 = 0, type2 = 0;
            int xornum = 0;
            for (int num : nums) {
                xornum ^= num;
            }
            for (int i = 1; i <= n; i++) {
                xornum ^= i;
            }
            Integer diff = xornum == Integer.MIN_VALUE ? xornum : xornum & (-xornum);
            for (int num : nums) {
                if ((num & diff) != 0) type1 ^= num;
                else type2 ^= num;
            }
            for (int i = 1; i <= n; i++) {
                if ((i & diff) != 0) {
                    type1 ^= i;
                } else type2 ^= i;
            }
            return new int[]{type1, type2};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

