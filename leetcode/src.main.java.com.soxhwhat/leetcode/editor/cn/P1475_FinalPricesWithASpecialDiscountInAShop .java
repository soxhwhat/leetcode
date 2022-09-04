package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 商品折扣后的最终价格
 *
 * @author soxhwhat
 */
class P1475_FinalPricesWithASpecialDiscountInAShop{
    public static void main(String[] args) {
        Solution solution = new P1475_FinalPricesWithASpecialDiscountInAShop().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = prices.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

