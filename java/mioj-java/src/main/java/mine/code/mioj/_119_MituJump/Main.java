package mine.code.mioj._119_MituJump;

/**
 * - 小米兔跳格子
 * 序号：#119
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：30M
 * 描述
 * 米兔爸爸为了让小米兔好好锻炼身体，便给小米兔设置了一个挑战——跳格子。
 *
 * 要吃到自己心爱的胡萝卜，小米兔需要跳过面前一些格子。现有 NN 个格子，每个格子内都写上了一个非负数，表示当前最多可以往前跳多少格，胡萝卜就放在最后一个格子上。米兔开始站在第 1 个格子，试判断米兔能不能跳到最后一个格子吃到胡萝卜呢？
 *
 * 输入
 * 输入为 NN 个数字 (N \lt 10N<10)，用空格隔开，第 ii 个数字 s_is
 * i
 * ​
 *   (0 \le s_i \lt 100≤s
 * i
 * ​
 *  <10) 表示米兔站在第 ii 个格子上时，最多能往前跳的格数。
 *
 * 输出
 * 若米兔能跳到最后一个格子上吃到胡萝卜，输出 “true“，否则输出 “false“
 *
 * 输入样例
 * 2 0 1 0 0 3 4
 *
 * 输出样例
 * false
 *
 *
 * Created by zhouyanhui on 2019/12/2.
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

    private static boolean solution(int[] ints) {
        if(ints.length == 0){
            return true;
        }
        boolean[] canReach = new boolean[ints.length];
        canReach[0] = true;
        for (int i = 0; i < ints.length; i++) {
            if(!canReach[i]){
                continue;
            }
            for (int j = 1; j <= ints[i]; j++) {
                if(i+j < ints.length) {
                    canReach[i + j] = true;
                }
            }
        }
        return canReach[ints.length-1];
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

