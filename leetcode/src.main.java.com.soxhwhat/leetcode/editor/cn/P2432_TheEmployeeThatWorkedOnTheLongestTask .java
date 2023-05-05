package leetcode.editor.cn;

/**
 * 处理用时最长的那个任务的员工
 * the-employee-that-worked-on-the-longest-task
 * 2023-05-05 14:26:54
 * @author soxhwhat
 */
class P2432_TheEmployeeThatWorkedOnTheLongestTask{
    public static void main(String[] args) {
        Solution solution = new P2432_TheEmployeeThatWorkedOnTheLongestTask().new Solution();
        //[[0,3],[2,5],[0,9],[1,15]]
        solution.hardestWorker(10,new int[][]{{0,3},{2,5},{0,9},{1,15}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int res = logs[0][1];
        int last = logs[0][0];

        int length = logs.length;
        for (int i = 1; i < length; i++) {
            int temp = logs[i][1] - logs[i - 1][1];
            int idx = logs[i][0];
            if (res < temp || (res == temp && last > idx)) {
                last = res == temp ? Math.min(last, idx) : idx;
                res = temp;
            }

        }
        return last;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}