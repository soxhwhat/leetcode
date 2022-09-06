package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最长数对链
 *
 * @author soxhwhat
 */
class P646_MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new P646_MaximumLengthOfPairChain().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {
            int pre = Integer.MIN_VALUE;
            int cnt = 0;
            Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
            for (int[] pair : pairs) {
                if (pair[0] > pre) {
                    pre = pair[1];
                    cnt++;
                } else if (pair[1] < pre){
                    pre = pair[1];
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

