package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 用栈操作构建数组
 * build-an-array-with-stack-operations
 * 2022-10-15 23:13:46
 * @author soxhwhat
 */
class P1441_BuildAnArrayWithStackOperations{
    public static void main(String[] args) {
        Solution solution = new P1441_BuildAnArrayWithStackOperations().new Solution();
        solution.buildArray(new int[]{1, 3}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> list = new ArrayList<>();
            int m = target.length;
            for (int i = 1, j = 0;  i <= n && j < m; i ++) {
                list.add("Push");
                if (target[j] != i) list.add("Pop");
                else j ++;

            }
            return list;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}