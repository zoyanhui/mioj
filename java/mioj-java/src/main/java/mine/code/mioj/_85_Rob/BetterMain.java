package mine.code.mioj._85_Rob;

/**
 * - 抢劫！
 * 序号：#85
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 你是一名专业劫匪，并且正在计划抢劫一条街道上的所有房子。每个房子有一定数量的现金。 唯一能够阻止你的就是安保系统被触发，当有两个相邻的房子在同一晚被劫时，安保系统才会自动触发。 现在给你一个正整数数组表示每家现金数，请求出这一晚你能在不触发安保系统时抢到的最大金额。
 *
 * 输入
 * 由逗号(,)分隔的一串正整数，表示这一条街上每个房子内的现金数。
 *
 * 输出
 * 一个正整数，表示你能抢到的最大金额。
 *
 * 输入样例
 * 1,2
 * 2,1,3,6,2
 *
 * 输出样例
 * 2
 * 8
 *
 * Created by zhouyanhui on 2019/11/26.
 */

import java.util.Scanner;

public class BetterMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int[] ints = splitToInts(line, ",");
            System.out.println(solution(ints));
        }
    }

    private static int solution(int[] ints) {
        if(ints.length == 0){
            return 0;
        }
        if(ints.length == 1){
            return ints[0];
        }
        if(ints.length == 2){
            return Math.max(ints[0], ints[1]);
        }
        int[] robbed = new int[ints.length];
        robbed[0] = ints[0];
        robbed[1] = Math.max(ints[0], ints[1]);
        for (int i = 2; i < ints.length; i++) {
            robbed[i] = Math.max(robbed[i-2] + ints[i], robbed[i-1]);
        }
        return robbed[ints.length-1];
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

