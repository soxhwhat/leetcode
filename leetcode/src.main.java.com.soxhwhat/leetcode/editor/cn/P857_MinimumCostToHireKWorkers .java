package leetcode.editor.cn;

import java.util.*;

/**
 * 雇佣 K 名工人的最低成本
 *
 * @author soxhwhat
 */
class P857_MinimumCostToHireKWorkers{
    public static void main(String[] args) {
        Solution solution = new P857_MinimumCostToHireKWorkers().new Solution();
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        solution.mincostToHireWorkers(quality, wage, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class Pair{
            double x; // 比值
            int y; // quality[i]

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }


            public Pair(double x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(1.0 * wage[i] / quality[i], quality[i]));
        }
        Collections.sort(list, Comparator.comparingDouble(Pair::getX)); // 比较自定义类的语法

        int sum = 0;
        double res = 1e10;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());// 定义大根堆
        for (Pair pair : list) {
            sum += pair.y;
            queue.add(pair.y);

            if(queue.size() > k) sum -= queue.remove();
            if(queue.size() == k) res = Math.min(res, sum * pair.x);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

