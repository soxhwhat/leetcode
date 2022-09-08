package leetcode.editor.cn;

/**
 * 优美的排列 II
 *
 * @author soxhwhat
 */
class P667_BeautifulArrangementIi{
    public static void main(String[] args) {
        Solution solution = new P667_BeautifulArrangementIi().new Solution();
        solution.constructArray(5, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArray(int n, int k) {
        int t = n - k - 1;
        int[] res = new int[n];
        for (int i = 0; i < t; i++) {
            res[i]  = i + 1;
        }
        for(int i = t, a = n - k, b = n; i < n; ){
            res[i ++ ] = a ++;
            if(i < n) res[i ++] = b --;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

