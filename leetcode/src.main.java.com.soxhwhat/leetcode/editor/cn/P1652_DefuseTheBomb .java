package leetcode.editor.cn;

/**
 * 拆炸弹
 *
 * @author soxhwhat
 */
class P1652_DefuseTheBomb {
    public static void main(String[] args) {
        Solution solution = new P1652_DefuseTheBomb().new Solution();
        solution.decrypt(new int[]{5,2,2,3,1}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] res = new int[n];
            if(k == 0) return  res;
            int[] sum = new int[2 * n + 1];
            for (int i = 1; i <= 2 * n; i++) sum[i] += sum[i - 1] + code[(i - 1) % n];
            for(int i = 1; i <= n; i ++){
                if(k < 0) res[i - 1] = sum[i + n - 1] - sum[i + k + n - 1];
                else res[i - 1] = sum[i + k] - sum[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

