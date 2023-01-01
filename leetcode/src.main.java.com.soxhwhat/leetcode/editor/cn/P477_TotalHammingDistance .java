package leetcode.editor.cn;

/**
 * 汉明距离总和
 * total-hamming-distance
 * 2023-01-01 11:44:57
 * @author soxhwhat
 */
class P477_TotalHammingDistance{
    public static void main(String[] args) {
        Solution solution = new P477_TotalHammingDistance().new Solution();
        int[] num = {4, 14, 2};
        solution.totalHammingDistance(num);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < 31; i++) {
            int x = 0, y = 0;
            for (int num : nums) {
                if ((num >> i & 1) != 0) x ++;
                else y ++;
            }
            res += x * y;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}