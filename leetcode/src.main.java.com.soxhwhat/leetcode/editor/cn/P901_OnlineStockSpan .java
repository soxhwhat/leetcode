package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * 股票价格跨度
 * online-stock-span
 * 2022-10-21 09:49:38
 *
 * @author soxhwhat
 */
class P901_OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner solution = new P901_OnlineStockSpan().new StockSpanner();
        solution.next(100);
        solution.next(80);
        solution.next(60);
        solution.next(70);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        ArrayDeque<int[]> stack;
        int idx;
        public StockSpanner() {
            stack = new ArrayDeque<>();
            stack.push(new int[]{Integer.MAX_VALUE, -1});
            idx = -1;
        }

        public int next(int price) {
            idx ++;
            while (price >= stack.peek()[0]) {
                stack.pop();
            }
            int res = idx - stack.peek()[1];
            stack.push(new int[]{price, idx});
            return res;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}