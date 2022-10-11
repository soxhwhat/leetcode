package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 优势洗牌
 *
 * @author soxhwhat
 */
class P870_AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new P870_AdvantageShuffle().new Solution();
        solution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            TreeSet<Integer> set = new TreeSet<>();
            for (int x : nums1) {
                map.put(x, map.getOrDefault(x, 0) + 1);
                if (map.get(x) == 1) set.add(x);
            }
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                Integer cur = set.ceiling(nums2[i] + 1);
                if (cur == null) cur = set.ceiling(-1);
                res[i] = cur;
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) set.remove(cur);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

