package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 子串能表示从 1 到 N 数字的二进制串
 * binary-string-with-substrings-representing-1-to-n
 * 2023-05-11 10:12:05
 * @author soxhwhat
 */
class P1016_BinaryStringWithSubstringsRepresenting1ToN{
    public static void main(String[] args) {
        Solution solution = new P1016_BinaryStringWithSubstringsRepresenting1ToN().new Solution();
        solution.queryString("110101011011000011011111000000", 15);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean queryString(String s, int n) {
        var seen = new HashSet<Integer>();
        var array = s.toCharArray();
        var m = array.length;
        for (int i = 0; i < m; i++) {
            var x = array[i] - '0';
            if (x == 0) continue;
            for (int j = i  + 1; x <= n; j ++) {
                seen.add(x);
                if (j == m) break;
                x = x << 1 | array[j] - '0';
            }
        }
        return seen.size() == n;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}