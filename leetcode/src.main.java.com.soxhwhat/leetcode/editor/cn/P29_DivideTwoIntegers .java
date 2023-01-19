package leetcode.editor.cn;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 两数相除
 * divide-two-integers
 * 2023-01-19 19:43:09
 *
 * @author soxhwhat
 */
class P29_DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29_DivideTwoIntegers().new Solution();
        solution.divide(-2147483648, -1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            ArrayList<Long> array = new ArrayList<Long>();
            boolean flag = true;
            long res = 0;
            if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) flag = false;
            long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
            for (long i = b; i <= a; i += i) array.add(i); //求最高位
            for (int i = array.size() - 1; i >= 0; i --) {
                if (a >= array.get(i)) {
                    a -= array.get(i);
                    res += 1L << i;
                }
            }
            if (!flag) res = -res;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) res = Integer.MAX_VALUE;
            return (int)res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}