package leetcode.editor.cn;

/**
 * 二进制矩阵中的特殊位置
 *
 * @author soxhwhat
 */
class P1582_SpecialPositionsInABinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new P1582_SpecialPositionsInABinaryMatrix().new Solution();
        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        solution.numSpecial(mat);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSpecial(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            int[] row = new int[n];
            int[] col = new int[m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    row[i] += mat[i][j];
                    col[j] += mat[i][j];
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1 ) cnt ++;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

