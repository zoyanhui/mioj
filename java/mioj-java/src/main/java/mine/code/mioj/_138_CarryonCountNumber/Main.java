package mine.code.mioj._138_CarryonCountNumber;

/**
 * - Carryon 数数字
 * 序号：#138
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：80M
 * 描述
 * Carryon 最近迷上了数数字，然后 Starry 给了他一个区间 [l, r][l,r] ,然后提了几个要求，
 *
 * 需要将 ll 到 rr 之间的数全部转化成 16 进制，然后连起来。
 * 将连起来的数又转化成 10 进制。
 * 将最终结果对 15 取模。
 * 数据范围：1 &lt;= l &lt;= r &lt;= 10000000000001<=l<=r<=1000000000000
 * 输入
 * 单组输入 ll 和 rr 的值
 *
 * 输出
 * 输出最终结果。
 *
 * 输入样例
 * 10 14
 *
 * 输出样例
 * 0
 *  复制样例
 * 小提示
 * 如：10、11、12、13、14的16进制分别是a、b、c、d、e。依次连在一起是abcde，转换成10进制是703710，对15取模为0。
 *
 *
 * Created by zhouyanhui on 2019/12/7.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            long[] ints = splitToInts(line, " ");
            System.out.println(solution(ints[0], ints[1]));
        }
    }

    private static long solution(long start, long end) {
        long M = 15;
        // sum(start,……,end) % M
        long s = start + end;
        if((s&1) == 0){
            s /= 2;
        }
        long c = end - start + 1;
        if((c & 1) == 0){
            c /= 2;
        }
        return ((s % M) * (c % M))%M;
    }

    private static long[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        long[] ret = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = Long.valueOf(split[i]);
        }
        return ret;
    }
}

