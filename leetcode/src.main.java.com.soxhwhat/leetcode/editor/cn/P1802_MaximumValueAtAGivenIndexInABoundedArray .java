package leetcode.editor.cn;

/**
 * 有界数组中指定下标处的最大值
 * maximum-value-at-a-given-index-in-a-bounded-array
 * 2023-01-04 12:20:41
 *
 * @author soxhwhat
 */
class P1802_MaximumValueAtAGivenIndexInABoundedArray {
    public static void main(String[] args) {
        Solution solution = new P1802_MaximumValueAtAGivenIndexInABoundedArray().new Solution();
        solution.maxValue(4, 2, 6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int left = 1;
            int right = maxSum;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                // 我们定义一个函数 sum(x, cnt)，表示一共有 cnt 个元素，且最大值为 x 的数组的总和
                if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private long sum(long x, int cnt) {
            return x >= cnt ? (x + x - cnt + 1) * cnt / 2 : (x + 1) * x / 2 + cnt - x;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}