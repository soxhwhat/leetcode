//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 2581, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import base.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * @author Soxhwhat
 * @date 2023-07-14 18:13:32
 */
public class P19_RemoveNthNodeFromEndOfList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
	 }
	 
//力扣代码
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);

		dummy.next = head;

		ListNode node = findFromEnd(dummy, n + 1);

		node.next = node.next.next;

		return dummy.next;


	}


	// 返回链表的倒数第 k 个节点
	ListNode findFromEnd(ListNode head, int k) {
		ListNode p1 = head;
		// p1 先走 k 步
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}
		ListNode p2 = head;
		// p1 和 p2 同时走 n - k 步
		while (p1 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		// p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
		return p2;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
