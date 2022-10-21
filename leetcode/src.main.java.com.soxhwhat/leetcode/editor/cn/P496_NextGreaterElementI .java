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
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[n];

        for (int i = m - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() < nums2[i]) deque.pop();
            int x = deque.isEmpty() ? -1 : deque.peek();
            map.put(nums2[i], x);
            deque.push(nums2[i]);
        }

        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

