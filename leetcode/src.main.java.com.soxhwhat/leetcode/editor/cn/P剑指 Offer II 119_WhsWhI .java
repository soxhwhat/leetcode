package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 最长连续序列
 * WhsWhI
 * 2022-12-13 18:04:00
 * @author soxhwhat
 */
class POfferII119_WhsWhI{
    public static void main(String[] args) {
        Solution solution = new POfferII119_WhsWhI().new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        solution.longestConsecutive(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num) && !set.contains(num - 1)) {
                 int end = num;
                 set.remove(end);
                 while (set.contains(num + 1)) {
                     num ++;
                     set.remove(num);
                 }
                res = Math.max(res, num - end + 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}