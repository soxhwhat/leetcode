package leetcode.editor.cn;

/**
 * 水果成篮
 * fruit-into-baskets
 * 2022-10-17 10:56:46
 *
 * @author soxhwhat
 */
class P904_FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new P904_FruitIntoBaskets().new Solution();
        solution.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            int res = 0;
            int n = fruits.length;
            int[] count = new int[n];
            for(int i = 0, j = 0, tot = 0; j < n; j ++) {
                if (count[fruits[j]] == 0) {
                    tot ++;
                }
                count[fruits[j]] ++;
                while (tot > 2) {
                    count[fruits[i]] --;
                    if (count[fruits[i]] == 0)  tot --;
                    i ++;
                }
                res = Math.max(res, j - i + 1);
            }
            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}