package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 强密码检验器 II
 * strong-password-checker-ii
 * 2023-01-19 19:04:29
 *
 * @author soxhwhat
 */
class P2299_StrongPasswordCheckerIi {
    public static void main(String[] args) {
        Solution solution = new P2299_StrongPasswordCheckerIi().new Solution();
        solution.strongPasswordCheckerII("IloveLe3tcode!");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] res = new int[4];
        public String s = "!@#$%^&*()-+";
        public boolean strongPasswordCheckerII(String password) {
            int n = password.length();
            if (n < 8) return false;
            for (int i = 0; i < n; i++) {
                char c = password.charAt(i);
                if (i > 0 && c == password.charAt(i - 1)) return false;
                getValue(c);
            }
            boolean flag = true;
            int sum = Arrays.stream(res)
                    .sum();
            return sum == 4;
        }

        public void getValue(char c) {
            if (res[2] != 0 && c >= '0' && c <= '9') res[2] = 1;
            else if (c >= 'a' && c <= 'z') res[0] = 1;
            else if (c >= 'A' && c <= 'Z') res[1] = 1;
            if (s.contains(c + "")) res[3] = 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}