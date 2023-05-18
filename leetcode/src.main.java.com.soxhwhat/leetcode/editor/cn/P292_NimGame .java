package leetcode.editor.cn;

/**
 * Nim 游戏
 * nim-game
 * 2023-05-16 10:41:15
 * @author soxhwhat
 */
class P292_NimGame{
    public static void main(String[] args) {
        Solution solution = new P292_NimGame().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}