package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 子域名访问计数
 * subdomain-visit-count
 * 2022-10-05 16:53:56
 *
 * @author soxhwhat
 */
class P811_SubdomainVisitCount {
    public static void main(String[] args) {
        Solution solution = new P811_SubdomainVisitCount().new Solution();
        solution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            List<String> res = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            for (String cpdomain : cpdomains) {
                String[] split = cpdomain.split(" ");
                int count = Integer.parseInt(split[0]);
                String domain = split[1];
                map.put(domain, map.getOrDefault(domain, 0) + count);
                for (int i = 0; i < domain.length(); i++) {
                    if (domain.charAt(i) == '.') {
                        String subDomain = domain.substring(i + 1);
                        map.put(subDomain, map.getOrDefault(subDomain, 0) + count);
                    }
                }
            }
            for (String key : map.keySet()) {
                res.add(map.get(key) + " " + key);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}