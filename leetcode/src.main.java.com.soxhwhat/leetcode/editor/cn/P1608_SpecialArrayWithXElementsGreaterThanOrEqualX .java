package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 特殊数组的特征值
 *
 * @author soxhwhat
 */
class P1608_SpecialArrayWithXElementsGreaterThanOrEqualX{
    public static void main(String[] args) {
        Solution solution = new P1608_SpecialArrayWithXElementsGreaterThanOrEqualX().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int x = 0; x < 1010; x++) {
            int l = 0, r = nums.length - 1;
            while (l < r){
                int mid = l + r >> 1;
                if(nums[mid] >= x){
                    r = mid;
                }else l = mid + 1;
            }
            if(nums[r] >= x && x == nums.length - r) return x;
        }
        return -1;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

