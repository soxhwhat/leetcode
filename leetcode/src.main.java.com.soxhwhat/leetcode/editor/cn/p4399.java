package leetcode.editor.cn;

/**
 * <p>在开始处详细描述该类的作用</p>
 * <p>描述请遵循 javadoc 规范</p>
 *
 * @author Soxhwhat
 * @date 2023/8/14 19:37
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class p4399 {
    public static int countInterestingLists(char[] books, int cnt) {
        int mod = (int) (1e9 + 7);
        int n = books.length;
        int[][] dp = new int[n + 1][cnt + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= cnt; j++) {
                // Case 1: Exclude the current book
                dp[i][j] = dp[i - 1][j];

                // Case 2: Include the current book
                for (int k = 1; k <= Math.min(j, countOccurrences(books, i - 1)) && k <= cnt; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= mod;
                }
            }
        }

        int total = 0;
        for (int j = 0; j <= cnt; j++) {
            total = (total + dp[n][j]) % mod;
        }

        return total;
    }

    private static int countOccurrences(char[] arr, int index) {
        int count = 0;
        for (int i = 0; i <= index; i++) {
            if (arr[i] == arr[index]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[] books = {'A', 'B', 'C', 'B'};
        int cnt = 1;
        System.out.println(countInterestingLists(books, cnt)); // Output: 8
    }
}
