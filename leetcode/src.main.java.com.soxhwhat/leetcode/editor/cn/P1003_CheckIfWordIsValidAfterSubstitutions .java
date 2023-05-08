package leetcode.editor.cn;

/**
 * 检查替换后的词是否有效
 * check-if-word-is-valid-after-substitutions
 * 2023-05-03 10:14:59
 * @author soxhwhat
 */
class P1003_CheckIfWordIsValidAfterSubstitutions{
    public static void main(String[] args) {
        Solution solution = new P1003_CheckIfWordIsValidAfterSubstitutions().new Solution();
        solution.isValid("aaaabcbcbcbc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 3 != 0) return false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            char c = s.charAt(i);
            sb.append(c);
            if (sb.length() >= 3 && sb.substring(sb.length() - 3).equals("abc")) {
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        return sb.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}