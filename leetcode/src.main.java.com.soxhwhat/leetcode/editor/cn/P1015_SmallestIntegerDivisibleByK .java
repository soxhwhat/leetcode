package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 可被 K 整除的最小整数
 * smallest-integer-divisible-by-k
 * 2023-05-10 18:01:25
 * @author soxhwhat
 */
class P1015_SmallestIntegerDivisibleByK{
    public static void main(String[] args) {
        Solution solution = new P1015_SmallestIntegerDivisibleByK().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRepunitDivByK(int k) {
        int resid = 1, len = 1;
        HashSet<Integer> set = new HashSet<>();
        while (resid % k != 0) {
            resid = (resid * 10 + 1) % k;
            if (set.contains(resid)) {
                return -1;
            }
            set.add(resid);
            len++;
        }
        return len;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}