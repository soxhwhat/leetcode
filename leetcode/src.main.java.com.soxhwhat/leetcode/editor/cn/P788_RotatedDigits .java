package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 旋转数字
 *
 * @author soxhwhat
 */
class P788_RotatedDigits {
    public static void main(String[] args) {
        Solution solution = new P788_RotatedDigits().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] st = {0, 1, 8};
        int[] vol = {2, 5, 6, 9};

        public int rotatedDigits(int n) {
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (check(i)) res++;
            }
            return res;
        }

        private boolean check(int i) {
            boolean flag = false;
            while (i > 0) {
                int k = i % 10;
                if (Arrays.binarySearch(st, k) >= 0) {
                    i /= 10;
                    continue;
                }
                if (Arrays.binarySearch(vol, k) >= 0) {
                    i /= 10;
                    flag = true;
                    continue;
                }
                return false;
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

