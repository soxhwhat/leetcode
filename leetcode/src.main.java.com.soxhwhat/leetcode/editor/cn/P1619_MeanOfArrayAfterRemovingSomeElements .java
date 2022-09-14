package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;

/**
 * 删除某些元素后的数组均值
 *
 * @author soxhwhat
 */
class P1619_MeanOfArrayAfterRemovingSomeElements {
    public static void main(String[] args) {
        Solution solution = new P1619_MeanOfArrayAfterRemovingSomeElements().new Solution();
        double v = solution.trimMean(new int[]{6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double trimMean(int[] arr) {
            int n = arr.length;
            int remove = n / 20;
            double sum = 0.0000;
            Arrays.sort(arr);
            for (int i = remove; i < n - remove; i++) {
                sum += arr[i];
            }
            double res = sum / (n - remove * 2);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}