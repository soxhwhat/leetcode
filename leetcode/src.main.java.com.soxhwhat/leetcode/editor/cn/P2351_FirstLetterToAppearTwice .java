package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 第一个出现两次的字母
 * first-letter-to-appear-twice
 * 2023-01-01 00:11:19
 * @author soxhwhat
 */
class P2351_FirstLetterToAppearTwice{
    public static void main(String[] args) {
        Solution solution = new P2351_FirstLetterToAppearTwice().new Solution();
        solution.repeatedCharacter("abccbaacz");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char repeatedCharacter(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            int t = 1 << (c - 'a');
            if ((res & t) > 0) return c;
            res |= t; //左移当前字母对应的位数
        }
        return  ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}