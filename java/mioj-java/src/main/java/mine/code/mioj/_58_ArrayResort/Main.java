package mine.code.mioj._58_ArrayResort;

/**
 * - 数组重排
 * 序号：#58
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个无序数组，只要对其中的一段子数组进行升序排列，就可以使整个数组变为升序。试求出这个子数组的长度。
 *
 * 举例： 有一个数组 [2, 6, 4, 8, 10, 9, 15]，只需对其子数组 [6, 4, 8, 10, 9] 进行升序排列，整个数组即可变为升序，所以返回子数组的长度5。
 *
 * 输入
 * 使用,分隔的一组整数，0<整数<100，0<整数个数<500。
 *
 * 输出
 * 一个整数，表示子数组的长度。
 *
 * 输入样例
 * 2,6,4,8,10,9,15
 *
 * 输出样例
 * 5
 *
 *
 * Created by zhouyanhui3 on 19-11-21.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int answer = solution(line);
            System.out.println(answer);
        }
    }

    private static int solution(String line) {
        int[] ints = splitToInts(line, ",");
        int[] nints = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            nints[i] = ints[i];
        }
        Arrays.sort(nints);
        int start = -1, end = -1;
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] != nints[i]){
                start = i;
                break;
            }
        }
        for (int i = ints.length - 1; i>=0; i--) {
            if(ints[i] != nints[i]){
                end = i;
                break;
            }
        }
        return end - start + 1;
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
