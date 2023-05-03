package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 强整数
 * powerful-integers
 * 2023-05-02 11:55:06
 * @author soxhwhat
 */
class P970_PowerfulIntegers{
    public static void main(String[] args) {
        Solution solution = new P970_PowerfulIntegers().new Solution();
        solution.powerfulIntegers(2, 3, 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                int sum = i + j;
                if (set.contains(sum)) continue;
                set.add(sum);
                list.add(sum);
                //防止无线循环下去
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}