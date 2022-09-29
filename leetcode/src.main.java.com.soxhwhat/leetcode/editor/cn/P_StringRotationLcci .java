package leetcode.editor.cn;

/**
 * 字符串轮转
 *
 * @author soxhwhat
 */
class P_StringRotationLcci{
    public static void main(String[] args) {
        Solution solution = new P_StringRotationLcci().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s = s1.repeat(2);
        return s.contains(s2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

