package leetcode.editor.cn;

/**
 * 上升下降字符串
 *
 * @author soxhwhat
 */
class P1370_IncreasingDecreasingString {
    public static void main(String[] args) {
        Solution solution = new P1370_IncreasingDecreasingString().new Solution();
        String s = solution.sortString("aaaabbbbcccc");
        System.out.print(s.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String sortString(String s) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int key = s.charAt(i) - 'a';
                cnt[key]++;

            }
            StringBuilder builder = new StringBuilder();
            while (builder.length() < s.length()) {

                for (int i = 0; i < 26; i++) {
                    if (cnt[i] > 0) {
                        builder.append((char) ('a' + i));
                        cnt[i]--;
                    }
                }
                for (int i = 25; i >= 0; i--) {
                    if (cnt[i] > 0) {
                        builder.append((char) ('a' + i));
                        cnt[i]--;
                    }
                }
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

