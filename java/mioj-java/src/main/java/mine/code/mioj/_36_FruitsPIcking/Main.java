package mine.code.mioj._36_FruitsPIcking;

/**
 * - 选水果
 * 序号：#36
 * 难度：非常难
 * 时间限制：1500ms
 * 内存限制：10M
 * 描述
 * 现在有2k个水果供你挑选，它们按照编号从小到大的顺序依次摆放在一个圆桌上，编号前k的水果由于放的太久已经坏掉了，后k个水果是新鲜的 。现在开始，你可以选择一个正整数m，然后从编号为1的水果开始挑选，每次拿走相隔m的水果。现在要求，在拿到坏水果前，必需把所有的好水果都拿走。问，给定一个k，求满足这个要求的最小的m，现在希望你写一个程序，计算出来这个m。
 *
 * 举例： 现在有6个水果供你选择(k = 3)，你选择的数字m=5，那么从1开始，你每拿到的水果编号依次是5,4,6,2,3,1。
 *
 * 输入
 * 一个正整数k，表示有几个新鲜水果与坏水果（0 < k < 14​)
 *
 * 输出
 * 一个正整数m，表示挑选水果时的最小相隔
 *
 * 输入样例
 * 3
 * 4
 *
 * 输出样例
 * 5
 * 30
 * Created by zhouyanhui on 2019/11/16.
 */

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int answer = solution(line);
            System.out.println(answer);
        }
    }

    private static int solution(String line) {
        int k = Integer.valueOf(line);
        int m = (k + 1) + 1;
        if (check(k, m)) {
            return m;
        }
        for (int i = 1; ; i++) {
            m = i * (k + 1);
            if (check(k, m)) {
                return m;
            }
            m = i * (k + 1) + 1;
            if (check(k, m)) {
                return m;
            }
        }
    }

    private static boolean check(int k, int m) {
        int start = 0;

        int loop = 2 * k;
        while (loop > k) {
            int next = (start + m) % loop;
            if (next <= k && next > 0) {
                return false;
            }
            loop--;
            start = next == 0 ? 0 : next - 1;
        }
        return true;
    }
}
