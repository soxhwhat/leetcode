package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个相同字符之间的最长子字符串
 *
 * @author soxhwhat
 */
class P1624_LargestSubstringBetweenTwoEqualCharacters{
    public static void main(String[] args) {
        Solution solution = new P1624_LargestSubstringBetweenTwoEqualCharacters().new Solution();
        solution.maxLengthBetweenEqualCharacters("cbzxy");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                Integer pos = map.get(c);
                res = Math.max(res, i - pos - 1);
            }else{
                map.put(c, i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

