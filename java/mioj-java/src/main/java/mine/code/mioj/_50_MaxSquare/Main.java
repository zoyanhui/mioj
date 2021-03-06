package mine.code.mioj._50_MaxSquare;

/**
 * - 找出面积最大的矩形
 * 序号：#50
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 在一个平面图上，有多个宽度固定为1，高度不同的矩形并列排着，在这些矩形所组成的图形中，能够切割出的最大矩形的面积是多少？ 数据范围：0 < 高度 < 100
 *
 * 举例：高度为2,3,2的三个矩形所组成的图形，能够切割出的最大的矩形面积为6。见下图。
 *
 *
 *
 * 输入
 * 一组正整数，分别用逗号隔开，表示每个矩形的高度
 *
 * 输出
 * 一个整数，表示组合成的最大的矩形面积
 *
 * 输入样例
 * 2,3,2
 * 5,6,7,8,3
 *
 * 输出样例
 * 6
 * 20
 *
 * Created by zhouyanhui on 2019/11/19.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            long answer = solution(line);
            System.out.println(answer);
        }
    }

    private static long solution(String line) {
        int[] ints = splitToInts(line, ",");
        int[] area = new int[101];
        long max = 0;
        for (int i = 0; i < ints.length; i++) {
            int n = ints[i];
            for (int j = n + 1; j < area.length; j++) {
                if(area[j] == 0){
                    break;
                }
                max = Math.max(max, area[j] * j);
                area[j] = 0;
            }
            for (int j = 1; j <= n; j++) {
                area[j] += 1;
            }
        }
        for (int j = 1; j < area.length; j++) {
            if(area[j] == 0){
                break;
            }
            max = Math.max(max, area[j] * j);
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

