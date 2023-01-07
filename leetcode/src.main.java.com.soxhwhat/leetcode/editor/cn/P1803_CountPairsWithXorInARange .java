package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 统计异或值在范围内的数对有多少
 * count-pairs-with-xor-in-a-range
 * 2023-01-05 09:36:22
 * @author soxhwhat
 */
class P1803_CountPairsWithXorInARange{
    public static void main(String[] args) {
        Solution solution = new P1803_CountPairsWithXorInARange().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int n = Integer.toBinaryString(100000).length();

        public int countPairs(int[] nums, int low, int high) {
            Node root = new Node();
            int h = high;
            int l = low - 1;
            int ans = 0;
            for (int num : nums) {
                ans += find(root, num, h) - find(root, num, l);
                add(root, num);
            }
            return ans;
        }

        private void add(Node root, int num) {
            Node node = root;
            for (int i = n; i >= 0; i--) {
                int cur = (num >> i) & 1;
                node = node.computeIfAbsent(cur, k -> new Node());
                node.cnt++;
            }

        }

        private int find(Node root, int num, int range) {
            Node node = root;
            int ans = 0;
            for (int i = n; i >= 0 && node != null; i--) {
                int cur = (num >> i) & 1;
                int r = (range >> i) & 1;
                if (r == 1) {
                    ans += node.getOrDefault(cur, new Node()).cnt;
                }
                node = node.get(cur ^ r);
            }
            if (node != null) {
                ans += node.cnt;
            }
            return ans;
        }

        class Node extends HashMap<Integer, Node> {
            int cnt;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}