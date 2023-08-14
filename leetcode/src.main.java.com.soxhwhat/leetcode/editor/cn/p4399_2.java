package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>在开始处详细描述该类的作用</p>
 * <p>描述请遵循 javadoc 规范</p>
 *
 * @author Soxhwhat
 * @date 2023/8/14 19:40
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class p4399_2 {
    /**
     * 大数相减
     * 以字符串的形式读入两个数字a,b a >= b)，编写一个函数计算它们的差(a  b)，以字符串形式返回
     * 数据范围: 每个数字的长度均为 1<= len <= 10000要求: 时间复杂度 O(n)
     * 示例输入:
     * 100 1
     * 输出:
     * 99
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = s1.length() - 1; i >= 0; i--) list.add(s1.charAt(i) - '0');
        for (int i = s2.length() - 1; i >= 0; i--) list1.add(s2.charAt(i) - '0');
        if (!check(list, list1)) {
            System.out.print("-");
        }
        List<Integer> sub = getSub(list, list1);
        for (int i = sub.size() - 1; i >= 0; i--) {
            System.out.print(sub.get(i));
        }


    }

    public static List<Integer> getSub(List<Integer> list, List<Integer> list1) {
        if (!check(list, list1)) {
            return getSub(list1, list);
        }

        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < list.size(); i++) {
            //这里应该是A.get(i) - list1.get(i) - t ，因为可能B为零，所以需要判断一下是不是存在
            t = list.get(i) - t;
            if (i < list1.size()) t -= list1.get(i);
            C.add((t + 10) % 10);

            if (t < 0) t = 1;
            else t = 0;
        }
        //删除指定下标下面的值
        while (C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);

        return C;
    }

    public static boolean check(List<Integer> list, List<Integer> list1) {
        if (list.size() != list1.size()) return list.size() > list1.size();

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != list1.get(i)) {
                return list.get(i) > list1.get(i);
            }
        }
        return true;
    }

}
