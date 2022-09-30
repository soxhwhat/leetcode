package leetcode.editor.cn;

/**
 * 零矩阵
 *
 * @author soxhwhat
 */
class P_ZeroMatrixLcci{
public static void main(String[]args){
        Solution solution=new P_ZeroMatrixLcci().new Solution();

        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {


        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) matrix[i][j] = 0;
            }
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}