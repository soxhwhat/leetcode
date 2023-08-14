package leetcode.editor.cn;

/**
 * <p>在开始处详细描述该类的作用</p>
 * <p>描述请遵循 javadoc 规范</p>
 *
 * @author Soxhwhat
 * @date 2023/8/13 20:46
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class mi {
    /**
     *  米小游拿到了一棵有根树，树上有n个节点，根节点编号为1，所有边的长度均为1。
     * 米小游每一次操作可以将一个新叶子节点接在原来的一个叶子上，新加的边的边长度也是1。米小游可以进行任意次操作。
     * 她想知道，操作结束后，与根节点的距离不超过k的节点个数的最大值是多少。
     *
     * 第一行输入两个整数 n(1 <= n <= 10^5),k(0<K< 10^9)
     * 接下来n-1行，每行输入两个整数 u,v表示节点u 和节点v之间有一条边
     * 根本身不算节点个数
     *
     */
    public static void main(String[] args) {
        Solution solution = new mi().new Solution();
    }

    private class Solution {
        /**
         *     /**
         *      *  米小游拿到了一棵有根树，树上有n个节点，根节点编号为1，所有边的长度均为1。
         *      * 米小游每一次操作可以将一个新叶子节点接在原来的一个叶子上，新加的边的边长度也是1。米小游可以进行任意次操作。
         *      * 她想知道，操作结束后，与根节点的距离不超过k的节点个数的最大值是多少。
         *      *
         *      * 第一行输入两个整数 n(1 <= n <= 10^5),k(0<K< 10^9)
         *      * 接下来n-1行，每行输入两个整数 u,v表示节点u 和节点v之间有一条边
         *      * 根本身不算节点个数
         *      *
            *      */
        public int sufficientSubset(TreeNode root, int limit) {
            //input 4 2
            //1 2
            //1 3
            //2 4
            //output 5

            return dfs(root, 0, limit);
        }

        private int dfs(TreeNode root, int i, int limit) {
            if (root == null) return 0;
            int temp = i + root.val;
            if (root.left == null && root.right == null) return temp >= limit ? 1 : 0;

            int left = dfs(root.left, temp, limit);
            int right = dfs(root.right, temp, limit);

            if (left == 0) root.left = null;
            if (right == 0) root.right = null;

            return left + right;

        }
    }
}
