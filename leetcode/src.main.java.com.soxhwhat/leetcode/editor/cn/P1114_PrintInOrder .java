package leetcode.editor.cn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 按序打印
 *
 * @author soxhwhat
 */
class P1114_PrintInOrder {
    public static void main(String[] args) {
        Foo solution = new P1114_PrintInOrder().new Foo();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {
        private BlockingQueue<String> one, two;

        public Foo() {
            one = new SynchronousQueue<>();
            two = new SynchronousQueue<>();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            one.put("startSecond");
        }

        public void second(Runnable printSecond) throws InterruptedException {
            one.take();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            two.put("startThird");
        }

        public void third(Runnable printThird) throws InterruptedException {
            two.take();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

