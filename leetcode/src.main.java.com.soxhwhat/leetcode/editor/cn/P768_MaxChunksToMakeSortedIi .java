package leetcode.editor.cn;

/**
 * 最多能完成排序的块 II
 *
 * @author soxhwhat
 */
class P768_MaxChunksToMakeSortedIi {
    public static void main(String[] args) {
        Solution solution = new P768_MaxChunksToMakeSortedIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int[] leftMax = new int[n];
            int[] rightMin = new int[n];

            int res = 1;
            leftMax[0] = arr[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
            }

            rightMin[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
            }
            for (int i = 0; i < n - 1; i++) {
                if (leftMax[i] <= rightMin[i + 1]) res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

