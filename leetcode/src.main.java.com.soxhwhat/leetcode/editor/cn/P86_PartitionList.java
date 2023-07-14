//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 729, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import base.ListNode;

/**
分隔链表
@author Soxhwhat
@date 2023-07-14 16:37:24
 */
public class P86_PartitionList {
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P86_PartitionList().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
Definition for singly-linked list.
 */

	class Solution {
    public ListNode partition(ListNode head, int x) {
		ListNode dummy1 = new ListNode(-1), p1 = dummy1;
		ListNode dummy2 = new ListNode(-1), p2 = dummy2;

		ListNode p = head;

		while (p != null) {
			if (p.val >= x) {
				p2.next = p;
				p2 = p2.next;
			} else {
				p1.next = p;
				p1 = p1.next;
			}
			p = p.next;
		}
		p2.next = null;
		p1.next = dummy2.next;

		return dummy1.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
