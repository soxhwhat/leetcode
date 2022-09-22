package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 能否连接形成数组
 *
 * @author soxhwhat
 */
class P1640_CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        Solution solution = new P1640_CheckArrayFormationThroughConcatenation().new Solution();
        solution.canFormArray(new int[]{1}, new int[][]{{1}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }
            for (int[] piece : pieces) {
                int index = map.getOrDefault(piece[0], -1);
                if (index == -1) {
                    return false;
                }
                for (int i = 1; i < piece.length; i++) {
                    if (index + i >= arr.length || arr[index + i] != piece[i]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}