package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author soxhwhat
 */
class P1_TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1_TwoSum().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i ++){
            int j = target - nums[i];
            if(map.containsKey(j)){
                res[1] = i;
                res[0] = map.get(j);
            }
            map.put(nums[i], i);
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

