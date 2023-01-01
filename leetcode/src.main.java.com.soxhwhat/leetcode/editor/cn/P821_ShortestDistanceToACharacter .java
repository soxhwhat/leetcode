package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 字符的最短距离
 * shortest-distance-to-a-character
 * 2022-12-13 16:21:01
 * @author soxhwhat
 */
class P821_ShortestDistanceToACharacter{
    public static void main(String[] args) {
        Solution solution = new P821_ShortestDistanceToACharacter().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, n + 1);
        for (int i = 0, j = -1; i < n; i ++) {
            if (s.charAt(i) == c) j = i;
            if (j != -1) ans[i] = i - j;
        }

        for(int i = n - 1, j = -1; i >= 0; i --) {
            if (s.charAt(i) == c) j = i;
            if (j != -1) ans[i] = Math.min(ans[i], j - i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}