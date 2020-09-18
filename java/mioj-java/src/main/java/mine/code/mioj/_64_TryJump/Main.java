package mine.code.mioj._64_TryJump;

/**
 * - 跳跳看
 * 序号：#64
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给定一个数字串 (均为正整数)，现在需要从第一个数跳跃到最后一个，所在位置的数字表示可以跳跃的最大步数。求出从第一个位置跳跃到最后位置所需的最少步数。
 *
 * 输入
 * 一个数字串，每个数字用空格隔开，如 1 2 3 4 5 6 7。
 *
 * 输出
 * 需要从第一位 1 跳到最后一位 7，则 1->2->4->7，最少需要3步。
 *
 * 输入样例
 * 1 2 3 4 5 6 7
 * 3 1 1 1 1
 * 2 3 2 3 2 3 2 3 2 3
 * 2 3 4 2 5 2 3 5 1 2 3 4
 *
 * 输出样例
 * 3
 * 2
 * 5
 * 4
 *
 * Created by zhouyanhui on 2019/11/24.
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
        int[] steps = new int[ints.length];
        steps[0] = 0;
        for (int i = 1; i < steps.length; i++) {
            steps[i] = ints.length + 1;
        }
        for (int i = 0; i < ints.length; i++) {
            for (int j = 1; j <= ints[i] && j < steps.length - i; j++) {
                steps[i+j] = Math.min(steps[i+j], steps[i] + 1);
            }
        }
        return steps[ints.length-1];
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

