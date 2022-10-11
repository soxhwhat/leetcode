package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 使序列递增的最小交换次数
 *
 * @author soxhwhat
 */
class P801_MinimumSwapsToMakeSequencesIncreasing {
    public static void main(String[] args) {
        Solution solution = new P801_MinimumSwapsToMakeSequencesIncreasing().new Solution();
        solution.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwap(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] swap = new int[n];
            int[] noSwap = new int[n];
            Arrays.fill(swap, Integer.MAX_VALUE);
            Arrays.fill(noSwap, Integer.MAX_VALUE);
            swap[0] = 1;
            noSwap[0] = 0;
            for (int i = 1; i < n; i++) {
                if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                    swap[i] = swap[i - 1] + 1;
                    noSwap[i] = noSwap[i - 1];
                }
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    swap[i] = Math.min(swap[i], noSwap[i - 1] + 1);
                    noSwap[i] = Math.min(noSwap[i], swap[i - 1]);
                }
            }
            return Math.min(swap[n - 1], noSwap[n - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

