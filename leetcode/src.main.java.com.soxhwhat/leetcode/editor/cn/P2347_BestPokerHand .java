package leetcode.editor.cn;

/**
 * 最好的扑克手牌
 * best-poker-hand
 * 2023-05-10 09:49:54
 *
 * @author soxhwhat
 */
class P2347_BestPokerHand {
    public static void main(String[] args) {
        Solution solution = new P2347_BestPokerHand().new Solution();
        solution.bestHand(new int[]{4, 4, 2, 4, 3}, new char[]{'d', 'a', 'a', 'b', 'c'});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String bestHand(int[] ranks, char[] suits) {
            if (isFlush(suits)) {
                return "Flush";
            }

            boolean isPair = false;
            int cnt = 0;// 计数器，用于记录每种点数出现的次数
            for (int rank : ranks) {
                int mark = 1 << (rank << 1);// 根据点数计算掩码
                if ((cnt & mark << 1) != 0) {// 如果之前已经有两张同点数的牌了，则表示出现了三条，返回结果
                     return "Three of a Kind";
                }

                isPair |= (cnt & mark) != 0; // 如果之前已经有一张同点数的牌了，则标记为 true
                cnt += mark; // 更新计数器
            }
            return isPair ? "Pair" : "High Card";
        }

        private static boolean isFlush(char[] suits) {
            for (int c = suits[0], i = suits.length - 1; i > 0; i--) {
                if (suits[i] != c) {
                    return false;
                }
            }
            return true;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}