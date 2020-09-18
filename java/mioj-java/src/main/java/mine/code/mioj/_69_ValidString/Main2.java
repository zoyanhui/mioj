package mine.code.mioj._69_ValidString;

/**
 * - 合法字符串
 * 序号：#69
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 假设字符串只可能由A、B、C三个字母组成，如果任何紧邻的三个字母相同，就非法。求长度为 N 的合法字符串有多少个？ 比如： ABBBCA 是非法，ACCBCCA 是合法的。
 *
 * 输入
 * 一个正整数 N，设 0 <= N <= 40
 *
 * 输出
 * 长度为N的合法字符串的个数
 *
 * 输入样例
 * 1
 * 2
 * 4
 * 22
 *
 * 输出样例
 * 3
 * 9
 * 66
 * 4739607552
 *
 * Created by zhouyanhui on 2019/11/24.
 */

import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int N = Integer.valueOf(line);
            System.out.println(solution(N));
        }
    }

    private static long solution(int n) {
        if(n < 3){
            return (long)Math.pow(3, n);
        }
        long[] a1End = new long[n+1]; // 结尾没有重复的
        a1End[0] = 0; a1End[1] = 3; a1End[2] = 6;
        long[] a2End = new long[n+1]; // 结尾两个重复的
        a2End[0] = 0; a2End[1] = 0; a2End[2] = 3;
        for (int i = 3; i <=n; i++) {
            a1End[i] = 2 * a2End[i - 1] + 2 * a1End[i - 1];
            a2End[i] = a1End[i - 1];
        }
        return a1End[n] + a2End[n];
    }
}

