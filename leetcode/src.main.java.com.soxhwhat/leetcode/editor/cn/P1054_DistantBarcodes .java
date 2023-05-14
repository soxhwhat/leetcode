package leetcode.editor.cn;

import java.util.*;

/**
 * 距离相等的条形码
 * distant-barcodes
 * 2023-05-14 10:24:46
 *
 * @author soxhwhat
 */
class P1054_DistantBarcodes {
    public static void main(String[] args) {
        Solution solution = new P1054_DistantBarcodes().new Solution();
        var res = solution.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            var pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
            var count = new HashMap<Integer, Integer>();
            var n = barcodes.length;
            for (int barcode : barcodes) {
                count.put(barcode, count.getOrDefault(barcode, 0) + 1);
            }
            for (var entry : count.entrySet()) {
                pq.offer(new int[]{entry.getValue(), entry.getKey()});
            }
            var res = new int[n];

            for (int i = 0; i < n; ++i) {
                int[] p = pq.poll();
                int cx = p[0], x = p[1];
                if (i == 0 || res[i - 1] != x) {
                    res[i] = x;
                    if (cx > 1) {
                        pq.offer(new int[]{cx - 1, x});
                    }
                } else {
                    int[] p2 = pq.poll();
                    int cy = p2[0], y = p2[1];
                    res[i] = y;
                    if (cy > 1) {
                        pq.offer(new int[]{cy - 1, y});
                    }
                    pq.offer(new int[]{cx, x});
                }
            }
            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
