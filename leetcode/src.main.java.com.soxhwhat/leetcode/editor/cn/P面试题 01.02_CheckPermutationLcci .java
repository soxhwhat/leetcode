package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 判定是否互为字符重排
 * check-permutation-lcci
 * 2023-01-17 09:54:33
 * @author soxhwhat
 */
class P_CheckPermutationLcci{
    public static void main(String[] args) {
        Solution solution = new P_CheckPermutationLcci().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}