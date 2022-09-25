package leetcode.editor.cn;

import java.util.ArrayList;

/**
 * 设计链表
 *
 * @author soxhwhat
 */
class P707_DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList solution = new P707_DesignLinkedList().new MyLinkedList();
        solution.addAtHead(1);
        solution.addAtTail(-1);
        solution.addAtIndex(2,2);
        solution.deleteAtIndex(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        ArrayList<Integer> list;

        public MyLinkedList() {
            list = new ArrayList<>();
        }

        public int get(int index) {
            return index < 0 || index >= list.size() ? -1 : list.get(index);
        }


        public void addAtHead(int val) {
            list.add(0, val);
        }

        public void addAtTail(int val) {
            list.add(val);
        }

        public void addAtIndex(int index, int val) {
            if (index <= list.size()) list.add(index, val);
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < list.size()) list.remove(index);
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

