//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1727, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import base.ListNode;

import java.util.List;


/**
 * 回文链表
 * @author Soxhwhat
 * @date 2023-07-17 09:33:14
 */
public class P234_PalindromeLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P234_PalindromeLinkedList().new Solution();
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
	ListNode left;
    public boolean isPalindrome(ListNode head) {

		ListNode midNode = getMidNode(head);

		//从slow开始反转后面的链表，现在就可以开始比较回文串了：
		ListNode left = head;
		ListNode right = reverse(midNode);

		while (right != null) {
			if (right.val != left.val) return false;
			left = left.next;
			right = right.next;
		}
		return true;

	}

	private ListNode reverse(ListNode midNode) {
		ListNode pre = null, cur = midNode;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}


	/**
	 * 在 学习数据结构的框架思维 中说过，链表兼具递归结构，树结构不过是链表的衍生。那么，链表其实也可以有前序遍历和后序遍历：
	 *
	 *
	 * @param head
	 */
	void traverse1(ListNode head) {
		if (head == null) return;
		// 前序遍历代码
		traverse1(head.next);
		// 后序遍历代码
		//print(head.val);
	}


	/**
	 * 利用后序遍历倒序链表
	 * @param right
	 * @return
	 */

	private boolean traverse(ListNode right) {
		if (right == null) return true;

		boolean res = traverse(right.next);
		//后序遍历代码
		//这么做的核心逻辑是什么呢？实际上就是把链表节点放入一个栈，然后再拿出来，这时候元素顺序就是反的，只不过我们利用的是递归函数的堆栈而已
		res = res && (right.val == left.val);
		left = left.next;
		return res;
	}

	private ListNode reverseNode(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode p = reverseNode(head.next);
		head.next.next = head;
		head.next = null;

		return p;
	}

	public String isPalindrome1(String s, int left, int right) {
		while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left --;
			right ++;
		}
		return s.substring(left + 1, right);
	}

	public ListNode getMidNode(ListNode head) {
		ListNode fast, slow;
		fast = slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//如果fast指针没有指向null，说明链表长度为奇数，slow还要再前进一步：
		if (fast != null) slow = slow.next;
		return slow;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
