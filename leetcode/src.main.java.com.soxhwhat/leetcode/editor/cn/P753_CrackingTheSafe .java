package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 破解保险箱
 * cracking-the-safe
 * 2023-01-10 12:20:19
 * @author soxhwhat
 */
class P753_CrackingTheSafe{
    public static void main(String[] args) {
        Solution solution = new P753_CrackingTheSafe().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Integer> seen = new HashSet<Integer>();
        StringBuffer ans = new StringBuffer();
        int highest;
        int k;

        public String crackSafe(int n, int k) {
            highest = (int) Math.pow(10, n - 1);
            this.k = k;
            dfs(0);
            for (int i = 1; i < n; i++) {
                ans.append('0');
            }
            return ans.toString();
        }

        public void dfs(int node) {
            for (int x = 0; x < k; ++x) {
                int nei = node * 10 + x;
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    dfs(nei % highest);
                    ans.append(x);
                }
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}