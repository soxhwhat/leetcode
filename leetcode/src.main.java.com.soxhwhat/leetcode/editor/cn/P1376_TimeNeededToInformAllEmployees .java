package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 通知所有员工所需的时间
 * time-needed-to-inform-all-employees
 * 2023-05-02 10:23:54
 *
 * @author soxhwhat
 */
class P1376_TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        Solution solution = new P1376_TimeNeededToInformAllEmployees().new Solution();
        solution.numOfMinutes(7,
                6,
                new int[]{1,2,3,4,5,6,-1},
                new int[]{0,6,5,4,3,2,1});
    };

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int N = 100005;
        static int[] h = new int[N];
        static int[] e = new int[N];
        static int[] w = new int[N];
        static int[] ne = new int[N];

        static int idx = 0;
        static void add(int a, int b, int c) {
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx++;
        }

        static int dfs (int u) {
            int d = 0;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                d = Math.max(d, dfs(j) + w[i]);
            }
            return d;
        }


        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Arrays.fill(h, - 1);
            idx = 0;
            for (int i = 0; i < manager.length; i++) {
                if (i == headID) continue;
                else add(manager[i], i, informTime[manager[i]]);
            }
            return dfs(headID);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}