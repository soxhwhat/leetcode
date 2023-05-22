package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 蓄水
 * o8SXZn
 * 2023-05-21 21:12:52
 * @author soxhwhat
 */
class PLCP33_O8SXZn{
    public static void main(String[] args) {
        Solution solution = new PLCP33_O8SXZn().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int max = Arrays.stream(vat).max().getAsInt();
        int res = Integer.MAX_VALUE;
        if (max == 0) return 0;
        for (int k = 1; k <= max; k ++) {
            int t = 0;
            for (int i = 0; i < bucket.length; i ++) {
                t += Math.max((vat[i] + k - 1) / k - bucket[i], 0);
            }
            res = Math.min(res, t + k);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}