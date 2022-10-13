package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 链表组件
 *
 * @author soxhwhat
 */
class P817_LinkedListComponents {
    public static void main(String[] args) {
        Solution solution = new P817_LinkedListComponents().new Solution();

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    class Solution {
        public int numComponents(ListNode head, int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;

            while (head != null) {
                if (set.contains(head.val)) {
                    while (head != null && set.contains(head.val)) head = head.next;
                    res ++;
                } else {
                    head = head.next;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

