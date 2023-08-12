import java.util.*;

public class Main {
    static int n;
    static boolean[] flag;
    static String str;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int try_(int x, int y) {
        int res = 0;
        flag = new boolean[10005];
        for (int i = 0; i < n; ++i) {
            flag[i] = false;
        }
        for (int i = 0; i < n; ++i){
            if (!flag[i]) {
                ++res;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                flag[i] = true;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    int ux = u / y;
                    int uy = u % y;
                    for (int d = 0; d < 4; ++d){
                        int vx = ux + dx[d];
                        int vy = uy + dy[d];
                        if (vx < 0 || vx >= x || vy < 0 || vy >= y)
                            continue;
                        int v = vx * y + vy;
                        if (flag[v]) continue;
                        if (str.charAt(v) != str.charAt(u)) continue;
                        q.add(v);
                        flag[v] = true;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        str = scanner.next();
        int ans = n;
        for (int i = 1; i * i <= n; ++i)
            if (n % i == 0) {
                ans = Math.min(ans, try_(i, n/i));
                ans = Math.min(ans, try_(n/i, i));
            }
        System.out.println(ans);
    }
}
