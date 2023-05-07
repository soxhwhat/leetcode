package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后 II
 * n-queens-ii
 * 2023-01-20 14:02:19
 * @author soxhwhat
 */
class P52_NQueensIi{
    public static void main(String[] args) {
        Solution solution = new P52_NQueensIi().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int N = 20;
        char[][] g = new char[N][N];
        boolean[] col = new boolean[N];
        boolean[] dg = new boolean[N];
        boolean[] udg = new boolean[N];
        List<List<String>> res = new ArrayList<>();

        public int totalNQueens(int n) {
            res.clear();

            for (int i = 0; i < N; i++) {
                Arrays.fill(g[i], '.');
            }
            dfs(0, n);
            return res.size();
        }

        public void dfs(int x, int n) {
            if (x == n) {
                List<String> array = new ArrayList<>();
                for (int i = 0; i < n; i ++) {
                    StringBuilder builder = new StringBuilder();
                    for (int j = 0; j < n; j ++) {
                        builder.append(g[i][j]);
                    }
                    array.add(builder.toString());
                }
                res.add(array);
                return;
            }

            for (int y = 0; y < n; y ++) {
                if (!col[y] && !dg[x + y] && !udg[y - x + n]) {
                    g[x][y] = 'Q';
                    col[y] = dg[x + y] = udg[y - x + n] = true;
                    dfs(x + 1, n);
                    col[y] = dg[x + y] = udg[y - x + n] = false;
                    g[x][y] = '.';
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}