package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Stream;

/**
 * 只出现一次的数字
 * single-number
 * 2023-03-27 23:30:03
 * @author soxhwhat
 */
class P136_SingleNumber{
    public static void main(String[] args) {
        Solution solution = new P136_SingleNumber().new Solution();
        solution.singleNumber(new int[]{2,2,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer temp = iterator.next();
            iterator.remove();
            if (list.indexOf(temp) == -1) return temp;

        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}