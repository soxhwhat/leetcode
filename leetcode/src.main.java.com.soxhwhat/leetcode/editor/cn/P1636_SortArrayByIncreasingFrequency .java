package leetcode.editor.cn;

import java.util.*;

/**
 * 按照频率将数组升序排序
 *
 * @author soxhwhat
 */
class P1636_SortArrayByIncreasingFrequency{
    public static void main(String[] args) {
        Solution solution = new P1636_SortArrayByIncreasingFrequency().new Solution();
        solution.frequencySort(new int[]{1,1,2,2,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        map.keySet().forEach(key -> list.add(new int[]{key, map.get(key)}));
        Collections.sort(list, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int[] ints : list) {
            for (int i = 0; i < ints[1]; i++) {
                ans[idx ++] = ints[0];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

