package leetcode.editor.cn;

/**
 * 统计各位数字之和为偶数的整数个数
 * count-integers-with-even-digit-sum
 * 2023-01-07 21:11:45
 * @author soxhwhat
 */
class P2180_CountIntegersWithEvenDigitSum{
    public static void main(String[] args) {
        Solution solution = new P2180_CountIntegersWithEvenDigitSum().new Solution();
        solution.countEven(15);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countEven(int num) {
        int y = num / 10, x = num % 10;
        int res = y * 5, ySum = 0;
        while (y != 0) {
            ySum += y % 10;
            y /= 10;
        }
        if (ySum % 2 == 0) {
            res += x / 2 + 1;
        } else {
            res += (x + 1) / 2;
        }
        // 多算了0
        return res - 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}