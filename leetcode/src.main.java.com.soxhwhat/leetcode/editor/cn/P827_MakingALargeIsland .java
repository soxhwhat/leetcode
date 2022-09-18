package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 最大人工岛
 *
 * @author soxhwhat
 */
class P827_MakingALargeIsland {
    public static void main(String[] args) {
        Solution solution = new P827_MakingALargeIsland().new Solution();
        int[][] test = {{1,0},{0,1}};
        solution.largestIsland(test);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n, m;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int[] p, size;

        public int largestIsland(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            p = new int[n * m];
            size = new int[n * m];
            for (int i = 0; i < n * m; i++) {
                p[i] = i;
                size[i] = 1;
            }
            int max = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        int a = getPosition(i, j);
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k], y = j + dy[k];
                            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                                int b = getPosition(x, y);
                                if (find(a) != find(b)) {
                                    size[find(b)] += size[find(a)];
                                    p[find(a)] = find(b);
                                }
                            }
                        }
                        max = Math.max(max, size[find(a)]);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(grid[i][j] == 0){
                        Map<Integer, Integer> hash = new HashMap<>();
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k], y = j + dy[k];
                            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                                int a = getPosition(x, y);
                                hash.put(find(a), size[find(a)]);
                            }
                        }
                        int s = 1;
                        for (Integer integer : hash.keySet()) {
                            s += hash.get(integer);
                        }
                        max = Math.max(s, max);
                    }
                }
            }
            return max;
        }

        public int getPosition(int x, int y) {
            return m * x + y;
        }

        public int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

