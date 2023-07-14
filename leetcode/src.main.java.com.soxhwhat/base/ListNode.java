package base;

/**
 * ListNode
 *
 * @author jaffe.huang@anker-in.com
 * @version 2023/07/14 16:41
 **/
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}