package leetcode.editor.cn;

/**
 * 最大交换
 *
 * @author soxhwhat
 */
class P670_MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new P670_MaximumSwap().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] chars = String.valueOf(num).toCharArray();
            int n = chars.length;
            int[] rightMax = new int[n];

            rightMax[n - 1] = n - 1;
            for (int i = n - 2; i >= 0; i--) {
                if (chars[i] > chars[rightMax[i + 1]]) {
                    rightMax[i] = i;
                } else {
                    rightMax[i] = rightMax[i + 1];
                }
            }
            for (int i = 0; i < n; i++) {
                if (chars[i] < chars[rightMax[i]]) {
                    char temp;
                    temp = chars[i];

                    chars[i] = chars[rightMax[i]];
                    chars[rightMax[i]] = temp;
                    break;
                }
            }
            return Integer.parseInt(String.valueOf(chars));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}