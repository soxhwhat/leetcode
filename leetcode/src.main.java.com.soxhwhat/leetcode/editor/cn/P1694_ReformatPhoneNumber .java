package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 重新格式化电话号码
 * reformat-phone-number
 * 2022-10-01 17:05:46
 * @author soxhwhat
 */
class P1694_ReformatPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P1694_ReformatPhoneNumber().new Solution();
        solution.reformatNumber("123 4-567");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformatNumber(String number) {
        String reg = "[\\s-]";
        String[] split = number.split(reg);
        String join = String.join("", split);
        int n = join.length();
        StringBuilder builder = new StringBuilder();
        final String c = "-";
        for (int i = 0; i < n; i += 3) {
            if (i != 0) {
                builder.append(c);
            }
            if (i + 5 > n) {
                if (i + 4 > n) builder.append(join.substring(i));
                else builder.append(join.substring(i, i + 2)).append(c).append(join.substring(i + 2));
                break;
            }
            builder.append(join.substring(i, i + 3));
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}