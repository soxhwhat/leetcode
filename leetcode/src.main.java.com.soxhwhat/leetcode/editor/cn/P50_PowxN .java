package leetcode.editor.cn;

/**
 * Pow(x, n)
 * powx-n
 * 2023-01-19 23:10:21
 * @author soxhwhat
 */
class P50_PowxN{
    public static void main(String[] args) {
        Solution solution = new P50_PowxN().new Solution();
        solution.myPow(4l,3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        boolean flag = n < 0;
        double res = 1;

        long k = Math.abs((long) n);
        while (k != 0) {
            if((k & 1) == 1) res *= x;
            k >>= 1;
            x *= x;
        }
        return flag ? 1 / res : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}