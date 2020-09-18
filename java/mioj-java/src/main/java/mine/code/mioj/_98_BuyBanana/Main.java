package mine.code.mioj._98_BuyBanana;

/**
 * - 买香蕉
 * 序号：#98
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 我是一个爱吃香蕉的强迫症。今天我要去水果店论筐买香蕉。 现在水果店有好多筐香蕉，我的要求是买回来的每一筐里必须有相同数量的香蕉。
 *
 * 为了实现这个目标，你可以每次做两件事情。
 * 1）放弃框里的一部分香蕉 2）连筐带香蕉放弃一整筐
 *
 * 我想知道我能得到最多多少香蕉。
 *
 * 输入
 * 以空格分割的多个正整数，每个正整数表示一筐香蕉的总香蕉数
 *
 * 输出
 * 最多能得到的香蕉数
 *
 * 输入样例
 * 1 2 3
 * 5 0 29 14
 *
 * 输出样例
 * 4
 * 29
 *
 *
 * Created by zhouyanhui on 2019/11/26.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int[] ints = splitToInts(line, " ");
            System.out.println(solution(ints));
        }
    }

    private static int solution(int[] ints) {
        Arrays.sort(ints);
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            max = Math.max(max, ints[i] * (ints.length - i));
        }
        return max;
    }

    private static int[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        int[] ret = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = Integer.valueOf(split[i]);
        }
        return ret;
    }
}

