package leetcode.editor.cn;

/**
 * 摘水果
 * maximum-fruits-harvested-after-at-most-k-steps
 * 2023-05-04 10:17:48
 * @author soxhwhat
 */
class P2106_MaximumFruitsHarvestedAfterAtMostKSteps{
    public static void main(String[] args) {
        Solution solution = new P2106_MaximumFruitsHarvestedAfterAtMostKSteps().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            int res = 0, s = 0;
            for (int i = 0, j = 0; j < fruits.length; j ++) {
                int pj = fruits[j][0], fj = fruits[j][1];
                s += fj;
                while (i <= j && pj - fruits[i][0] + Math.min(Math.abs(startPos - fruits[i][0]), Math.abs(startPos - pj)) > k) {
                    s -= fruits[i ++][1];
                }
                res = Math.max(res, s);
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}