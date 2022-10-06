package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 三等分
 * three-equal-parts
 * 2022-10-06 12:42:43
 *
 * @author soxhwhat
 */
class P927_ThreeEqualParts {
    public static void main(String[] args) {
        Solution solution = new P927_ThreeEqualParts().new Solution();
        solution.threeEqualParts(new int[]{1, 0, 1, 0, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] threeEqualParts(int[] arr) {
            int sum = Arrays.stream(arr).sum();
            if (sum % 3 != 0) return new int[]{-1, -1};
            if (sum == 0) return new int[]{0, arr.length - 1};
            int k = sum / 3;
            int cur = 0, s1 = 0, s2 = 0, s3 = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    if (cur == 0) s1 = i;
                    else if (cur == k) s2 = i;
                    else if (cur == 2 * k) s3 = i;
                    cur ++;
                }
            }
            while (s3 < arr.length && arr[s1] == arr[s2] && arr[s2] == arr[s3]) {
                s1 ++;
                s2 ++;
                s3 ++;
            }
            if (s3 == arr.length) return new int[]{s1 -1, s2};
            return new int[]{-1, -1};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}