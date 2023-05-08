package leetcode.editor.cn;

/**
 * 外观数列
 * count-and-say
 * 2023-04-30 11:05:03
 *
 * @author soxhwhat
 */
class P38_CountAndSay {
    public static void main(String[] args) {
        Solution solution = new P38_CountAndSay().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) return "1";
            String s = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    c = s.charAt(i);
                    count = 1;
                }
            }
            sb.append(count).append(c);
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}