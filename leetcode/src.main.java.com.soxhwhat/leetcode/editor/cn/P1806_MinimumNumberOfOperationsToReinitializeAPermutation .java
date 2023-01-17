package leetcode.editor.cn;

/**
 * 还原排列的最少操作步数
 * minimum-number-of-operations-to-reinitialize-a-permutation
 * 2023-01-09 11:05:05
 *
 * @author soxhwhat
 */
class P1806_MinimumNumberOfOperationsToReinitializeAPermutation {
    public static void main(String[] args) {
        Solution solution = new P1806_MinimumNumberOfOperationsToReinitializeAPermutation().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reinitializePermutation(int n) {
            int res = 0;
            int i = 1;
            while (true) {
                i = i % 2 == 0 ? i / 2 : n / 2 + i / 2;
                res++;
                if (i == 1) {
                    return res;
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}