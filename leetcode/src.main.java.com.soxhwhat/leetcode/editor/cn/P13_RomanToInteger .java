package leetcode.editor.cn;

/**
 * 罗马数字转整数
 * roman-to-integer
 * 2023-01-19 00:18:03
 * @author soxhwhat
 */
class P13_RomanToInteger{
    public static void main(String[] args) {
        Solution solution = new P13_RomanToInteger().new Solution();
        solution.romanToInt("MCMXCIV");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int romanToInt(String s) {
            char[] array = s.toCharArray();
            int res = getValue(array[0]);
            for (int i = 1; i < array.length; i++) {
                int pre = getValue(array[i - 1]);
                int value = getValue(array[i]);
                res += pre >= value ? value : value - 2 * pre;
            }
            return res;
        }


        public int getValue(char c) {
            return switch (c) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}