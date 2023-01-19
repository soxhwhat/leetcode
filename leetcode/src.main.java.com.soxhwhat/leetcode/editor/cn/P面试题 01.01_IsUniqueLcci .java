package leetcode.editor.cn;

/**
 * 判定字符是否唯一
 * is-unique-lcci
 * 2023-01-17 09:52:58
 * @author soxhwhat
 */
class P_IsUniqueLcci{
    public static void main(String[] args) {
        Solution solution = new P_IsUniqueLcci().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUnique(String astr) {
        int[] arr = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            if (arr[index] == 1) {
                return false;
            }
            arr[index] = 1;
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}