package mine.code.mioj._46_ArraySubstraction;

/**
 * - 数组差
 * 序号：#46
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组元素和的差的绝对值 |SUM(A) - SUM(B)| 最大。 返回这个最大的差值。 例如： 有一个数组{1, 2, -3, 1}，可以从中找出两个子数组A = {1, 2}与B = {-3}，这两个子数组的元素和分别为 SUM(A) = 3，SUM(B) = -3，因此可以求得差的最大值 |SUM(A) - SUM(B)| = 6。
 *
 * 输入
 * 使用逗号(,)分隔的一个整数数组
 *
 * 输出
 * 一个整数，表示两个子数组元素和的差的最大值
 *
 * 输入样例
 * 1,2,-3,1
 *
 * 输出样例
 * 6
 *
 * Created by zhouyanhui3 on 19-11-18.
 */

import java.util.Scanner;

public class BetterMain {
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

        long[] maxOfLeft = new long[ints.length];
        long[] minOfLeft = new long[ints.length];
        long[] maxOfRight = new long[ints.length];
        long[] minOfRight = new long[ints.length];
        calc(ints, maxOfLeft, minOfLeft, false);
        calc(ints, maxOfRight, minOfRight, true);
        long max = 0;
        for (int i = 1; i < ints.length; i++) {
            max = Math.max(Math.abs(maxOfLeft[i-1] - minOfRight[i]), max);
            max = Math.max(Math.abs(minOfLeft[i-1] - maxOfRight[i]), max);
        }
        return max;
    }

    private static void calc(int[] ints, long[] maxOfLeft, long[] minOfLeft, boolean reverse) {
        long curMin = 0, curMax = 0;
        long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        if(reverse){
            for (int i = ints.length - 1; i >= 0; i--) {
                curMax += ints[i];
                if (curMax > max) {
                    max = curMax;
                }
                maxOfLeft[i] = max;
                if (curMax < 0) {
                    curMax = 0;
                }
                curMin += ints[i];
                if (curMin < min) {
                    min = curMin;
                }
                minOfLeft[i] = min;
                if (curMin > 0) {
                    curMin = 0;
                }
            }
        }else {
            for (int i = 0; i < ints.length; i++) {
                curMax += ints[i];
                if (curMax > max) {
                    max = curMax;
                }
                maxOfLeft[i] = max;
                if (curMax < 0) {
                    curMax = 0;
                }
                curMin += ints[i];
                if (curMin < min) {
                    min = curMin;
                }
                minOfLeft[i] = min;
                if (curMin > 0) {
                    curMin = 0;
                }
            }
        }
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

