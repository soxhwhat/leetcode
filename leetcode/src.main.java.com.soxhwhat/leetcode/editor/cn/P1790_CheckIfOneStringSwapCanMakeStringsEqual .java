package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author soxhwhat
 */
class P1790_CheckIfOneStringSwapCanMakeStringsEqual{
    public static void main(String[] args) {
        Solution solution = new P1790_CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        solution.areAlmostEqual("bank", "kanb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s2.length();
        int[] ints = new int[26];
        int cnt = 0;
        for (int i = 0; i < s1.toCharArray().length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt ++;
            ints[s1.charAt(i) - 'a'] ++;
            ints[s2.charAt(i) - 'a'] --;
        }
        if (cnt > 2) return false;
        for (int i = 0; i < 26; i++) {
            if (ints[i] != 0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

