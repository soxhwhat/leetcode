package leetcode.editor.cn;

import base.ListNode;

import java.util.List;

/**
 * K 个一组翻转链表
 *
 * @author soxhwhat
 */
class P25_ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new P25_ReverseNodesInKGroup().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) return head;

        ListNode a, b;

        a = b = head;

        for (int i = 0; i < k; i ++) {
            //不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverseNode(a, b);

        a.next = reverseKGroup(b, k);

        return newHead;
    }

    /**
     * 反转head-b之间的链表(而不是第几个-第几个之间的节点）
     * @param head
     * @param b
     * @return
     */
    public ListNode reverseNode (ListNode head, ListNode b) {
        ListNode pre, cur, next;
        cur = next = head;
        pre = null;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;

        }
        return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}