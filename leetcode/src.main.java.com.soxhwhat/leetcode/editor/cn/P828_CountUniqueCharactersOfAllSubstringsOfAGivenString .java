package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 统计子串中的唯一字符
 *
 * @author soxhwhat
 */
class P828_CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public static void main(String[] args) {
        Solution solution = new P828_CountUniqueCharactersOfAllSubstringsOfAGivenString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniqueLetterString(String s) {
            //给数组赋值-1
            int[] temp = new int[26];
            Arrays.fill(temp, -1);
            int n = s.length();
            int[] left = new int[n];
            int[] right = new int[n];
            int res = 0;

            for (int i = 0; i < n; i++) {
                left[i] = temp[s.charAt(i) - 'A'];
                temp[s.charAt(i) - 'A'] = i;

            }
            Arrays.fill(temp, n);
            for (int i = n - 1; i >= 0; i--) {
                right[i] = temp[s.charAt(i) - 'A'];
                temp[s.charAt(i) - 'A'] = i;
            }
            for (int i = 0; i < n; i++) {
                res += (i - left[i]) * (right[i] - i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

