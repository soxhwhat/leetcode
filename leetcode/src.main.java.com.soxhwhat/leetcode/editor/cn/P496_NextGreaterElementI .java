//package leetcode.editor.cn;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//
///**
// * 下一个更大元素 I
// *
// * @author soxhwhat
// */
//class P496_NextGreaterElementI{
//    public static void main(String[] args) {
//        Solution solution = new P496_NextGreaterElementI().new Solution();
//
//    }
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int n = nums1.length;
//        int m = nums2.length;
//        int[] res = new int[n];
//        int[] temp = new int[m];
//        for (int i = 0; i < m; i++) {
//            while (!stack.isEmpty() && nums2[i] < stack.peek()){
//                stack.pop();
//                stack.push(nums2[i]);
//            }
//            temp[i] = stack.peek();
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if(nums1[i] == nums2[j]) res[i] = temp
//            }
//        }
//
//    }
//
//        private int findNext(int x, int[] num) {
//
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}
//
