package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 检查句子中的数字是否递增
 * check-if-numbers-are-ascending-in-a-sentence
 * 2023-01-03 10:08:09
 * @author soxhwhat
 */
class P2042_CheckIfNumbersAreAscendingInASentence{
    public static void main(String[] args) {
        Solution solution = new P2042_CheckIfNumbersAreAscendingInASentence().new Solution();
        solution.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areNumbersAscending(String s) {
        String[] split = s.split(" ");
        int pre = -1;
        for (String s1 : split) {
            if (s1.charAt(0) > '9') continue;
            int cur = Integer.parseInt(s1);
            if (cur <= pre) return false;
            pre = cur;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}