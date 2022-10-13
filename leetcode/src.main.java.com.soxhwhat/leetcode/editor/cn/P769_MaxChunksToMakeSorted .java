package leetcode.editor.cn;

/**
 * 最多能完成排序的块
 *
 * @author soxhwhat
 */
class P769_MaxChunksToMakeSorted {
    public static void main(String[] args) {
        Solution solution = new P769_MaxChunksToMakeSorted().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int[] left = new int[n];
            int[] right = new int[n];

            left[0] = arr[0];
            for(int i = 1; i < n; i ++) {
                left[i] = Math.max(left[i - 1], arr[i]);
            }
            right[n - 1] = arr[n - 1];
            for(int i = n - 2; i >= 0; i --) {
                right[i] = Math.min(right[i + 1], arr[i]);
            }
            int res = 1;
            for(int i = 0; i < n - 1; i ++) {
                if (left[i] <= right[i + 1]) res ++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

