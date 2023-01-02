package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 积压订单中的订单总数
 * number-of-orders-in-the-backlog
 * 2023-01-02 09:55:24
 *
 * @author soxhwhat
 */
class P1801_NumberOfOrdersInTheBacklog {
    public static void main(String[] args) {
        Solution solution = new P1801_NumberOfOrdersInTheBacklog().new Solution();
        solution.getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            //大根堆维护堆积订单
            PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            //小根堆维护售卖订单
            PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int ans = 0;
            for (int[] order : orders) {
                if (order[2] == 0) {
                    //买单
                    while (!sell.isEmpty() && sell.peek()[0] <= order[0] && order[1] > 0) {
                        int[] sellOrder = sell.poll();
                        if (sellOrder[1] > order[1]) {
                            sellOrder[1] -= order[1];
                            order[1] = 0;
                            sell.offer(sellOrder);
                        } else {
                            order[1] -= sellOrder[1];
                        }
                    }
                    if (order[1] > 0) {
                        buy.offer(order);
                    }
                } else {
                    //卖单
                    while (!buy.isEmpty() && buy.peek()[0] >= order[0] && order[1] > 0) {
                        int[] buyOrder = buy.poll();
                        if (buyOrder[1] > order[1]) {
                            buyOrder[1] -= order[1];
                            order[1] = 0;
                            buy.offer(buyOrder);
                        } else {
                            order[1] -= buyOrder[1];
                        }
                    }
                    if (order[1] > 0) {
                        sell.offer(order);
                    }
                }
            }
            while (!buy.isEmpty()) {
                ans += buy.poll()[1];
                ans %= 1000000007;
            }
            while (!sell.isEmpty()) {
                ans += sell.poll()[1];
                ans %= 1000000007;
            }
            return (int) (ans % 1000000007);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}