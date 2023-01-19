package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * N 字形变换
 * zigzag-conversion
 * 2023-02-12 18:22:40
 * @author soxhwhat
 */
class P6_ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new P6_ZigzagConversion().new Solution();
        solution.convert("AB", 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
         public String convert(String s, int numRows) {
            if (numRows < 2) return s;
            char[] ch = s.toCharArray();
            List<StringBuilder> list = new ArrayList<StringBuilder>();
            for (int i = 0; i < numRows; i ++) list.add(new StringBuilder());
            int i = 0, flag = -1;
            for (char c : ch) {
                list.get(i).append(c);
                if (i == 0 || i == numRows - 1) flag = -flag;
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for(StringBuilder sb : list) res.append(sb);
            return res.toString();

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}