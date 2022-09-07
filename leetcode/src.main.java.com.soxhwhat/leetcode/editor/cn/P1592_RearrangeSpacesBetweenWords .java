package leetcode.editor.cn;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 重新排列单词间的空格
 *
 * @author soxhwhat
 */
class P1592_RearrangeSpacesBetweenWords{
    public static void main(String[] args) {
        Solution solution = new P1592_RearrangeSpacesBetweenWords().new Solution();
        solution.reorderSpaces("  this   is  a sentence ");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorderSpaces(String text) {
        String[] arr = text.trim().split("\\s+");
        int wordCnt = arr.length;
        int spaceCnt = (int) text.chars().filter(x -> x == ' ').count();
        int spaceRepeat = wordCnt <= 1? 0 : spaceCnt / (wordCnt - 1);
        int lastRepeat = spaceCnt - spaceRepeat * (wordCnt - 1);
        return String.join(StringUtils.repeat(" ",spaceRepeat), arr) + " ".repeat(lastRepeat);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

