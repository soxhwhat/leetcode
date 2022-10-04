package leetcode.editor.cn;

/**
 * 检查二进制字符串字段
 * check-if-binary-string-has-at-most-one-segment-of-ones
 * 2022-10-03 23:04:09
 * @author soxhwhat
 */
class P1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes{
    public static void main(String[] args) {
        Solution solution = new P1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes().new Solution();
        solution.checkOnesSegment("110");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkOnesSegment(String s) {
        if (s.length() == 1) {
            return true;
        }
        return !s.contains("01");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}