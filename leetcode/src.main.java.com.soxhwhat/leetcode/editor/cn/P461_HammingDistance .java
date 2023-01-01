package leetcode.editor.cn;

/**
 * 汉明距离
 * hamming-distance
 * 2022-12-13 18:27:58
 * @author soxhwhat
 */
class P461_HammingDistance{
    public static void main(String[] args) {
        Solution solution = new P461_HammingDistance().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x !=0 || y != 0 ) {
            res += (x & 1) ^ (y & 1);//x^y是指x异或y，即x和y的二进制形式不同的位记为1，相同的位记为0。异或运算是位运算的一种，主要用于数据加密和数据校验。
            x >>= 1;
            y >>= 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}