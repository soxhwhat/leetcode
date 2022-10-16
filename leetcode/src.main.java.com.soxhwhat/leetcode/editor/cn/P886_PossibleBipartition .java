package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 可能的二分法
 * possible-bipartition
 * 2022-10-16 09:41:08
 *
 * @author soxhwhat
 */
class P886_PossibleBipartition {
    public static void main(String[] args) {
        Solution solution = new P886_PossibleBipartition().new Solution();
        solution.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final int N = (int) 1e5 + 10, M = 2 * N;
        int[] e = new int[M], ne = new int[M], h = new int[N], st = new int[N];
        int idx = 0;
        public boolean possibleBipartition(int n, int[][] dislikes) {
            Arrays.fill(h, -1);
            for (int[] dislike : dislikes) {
                int a = dislike[0] - 1, b = dislike[1] - 1;
                add(a, b);
                add(b, a);
            }
            for (int i = 0; i < n; i++) {
                if (st[i] == 0) {
                    if (!dfs(i, 1)) {
                        return false;
                    }
                }

            }
            return true;
        }

        private boolean dfs(int u, int color) {
            st[u] = color;
            for(int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (st[j] == 0) {
                    if (!dfs(j, 3 - color)) return false;
                } else if (st[j] == st[u]) return false;
            }
            return true;
        }

        public void add(int a, int b) {
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx ++;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}