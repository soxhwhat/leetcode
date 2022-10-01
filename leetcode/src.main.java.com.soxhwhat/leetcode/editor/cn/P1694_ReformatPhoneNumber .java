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
        solution.reformatNumber("1-23-45 67");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformatNumber(String number) {
        String reg = "[\\s-]";
        String[] split = number.split(reg);
        String s = String.join("", split);
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            if (builder.length() != 0) builder.append("-");
            if (i + 5 > n){
                if (i + 3 >= n) builder.append(s.substring(i));
                else builder.append(s.substring(i, i + 2)).append("-").append(s.substring(i + 2));
                break;
            }
            builder.append(s.substring(i, i + 3));
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}