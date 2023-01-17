package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 替换字符串中的括号内容
 * evaluate-the-bracket-pairs-of-a-string
 * 2023-01-12 23:53:11
 *
 * @author soxhwhat
 */
class P1807_EvaluateTheBracketPairsOfAString {
    public static void main(String[] args) {
        Solution solution = new P1807_EvaluateTheBracketPairsOfAString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> dict = new HashMap<String, String>();
            for (List<String> kd : knowledge) {
                dict.put(kd.get(0), kd.get(1));
            }
            boolean addKey = false;
            StringBuilder key = new StringBuilder();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    addKey = true;
                } else if (c == ')') {
                    if (dict.containsKey(key.toString())) {
                        res.append(dict.get(key.toString()));
                    } else {
                        res.append('?');
                    }
                    addKey = false;
                    key.setLength(0);
                } else {
                    if (addKey) {
                        key.append(c);
                    } else {
                        res.append(c);
                    }
                }
            }
            return res.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    }