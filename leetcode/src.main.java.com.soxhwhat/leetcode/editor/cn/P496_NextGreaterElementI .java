package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * 下一个更大元素 I
 *
 * @author soxhwhat
 */
class P496_NextGreaterElementI{
    public static void main(String[] args) {
        Solution solution = new P496_NextGreaterElementI().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[n];

        for (int i = m - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();
            int x = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], x);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

