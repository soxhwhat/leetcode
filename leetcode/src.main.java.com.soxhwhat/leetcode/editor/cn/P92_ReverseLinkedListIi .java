package leetcode.editor.cn;

import base.ListNode;

import java.time.temporal.JulianFields;
import java.util.List;

/**
 * 反转链表 II
 *
 * @author soxhwhat
 */
class P92_ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92_ReverseLinkedListIi().new Solution();
        
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) return reverseN(head, right);

        //如果 m != 1 怎么办？如果我们把 head 的索引视为 1，那么我们是想从第 m 个元素开始反转对吧；如果把 head.next 的索引视为 1 呢？那么相对于 head.next，反转的区间应该是从第 m - 1 个元素开始的；那么对于 head.next.next 呢……
        //区别于迭代思想，这就是递归思想，所以我们可以完成代码
        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;


    }

    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}