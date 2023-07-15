package leetcode.editor.cn;

import base.ListNode;

/**
 * 反转链表
 *
 * @author soxhwhat
 */
class P206_ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();
        
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
    public ListNode reverseList(ListNode head) {
        //意思是如果链表为空或者只有一个节点的时候，反转结果就是它自己，直接返回即可。
        if (head == null || head.next == null) return head;

        //对于递归算法，最重要的就是明确递归函数的定义。具体来说，我们的 reverse 函数定义是这样的：
        //输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
        //不要跳进递归（你的脑袋能压几个栈呀？），而是要根据刚才的函数定义，来弄清楚这段代码会产生什么结果：
        ListNode node = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return node;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}