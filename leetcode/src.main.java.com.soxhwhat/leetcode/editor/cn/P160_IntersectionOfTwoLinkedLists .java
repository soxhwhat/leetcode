package leetcode.editor.cn;

import base.ListNode;

/**
 * 相交链表
 *
 * @author soxhwhat
 */
class P160_IntersectionOfTwoLinkedLists{
    public static void main(String[] args) {
        Solution solution = new P160_IntersectionOfTwoLinkedLists().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            if (p1 == null) p1.next = headB;
            else p1 = p1.next;

            if (p2 == null) p2.next = headA;
            else p2 = p2.next;
        }
        return p1;

        // A B C D E
        // F G D E

        // A B C D E F G D E
        // F G D E A B C D E
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}