package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 有效的数独
 * valid-sudoku
 * 2023-04-30 10:07:17
 *
 * @author soxhwhat
 */
class P36_ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new P36_ValidSudoku().new Solution();
        //[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'1', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
        };
        solution.isValidSudoku(board);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[] rows = new int[9];
            int[] cols = new int[9];
            int[] cubes = new int[9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    int num = c - '0';

                    if (c == '.') continue;
                    if (num <= 0 || num > 9) return false;
                    if ((rows[i] & (1 << num)) != 0
                            || (cols[j] & (1 << num)) != 0
                            || (cubes[(i / 3) * 3 + (j / 3)] & (1 << num)) != 0) {
                        return false;
                    }
                    rows[i] |= (1 << num);
                    cols[j] |= (1 << num);
                    cubes[(i / 3) * 3 + (j / 3)] |= (1 << num);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}