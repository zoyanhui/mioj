package mine.code.mioj._107_SolveResidue;

/**
 * - 求余
 * 序号：#107
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * f(N) = 3^0 + 3^1 + ... + 3^N 求 f(N) 除以 1000000007 的余数
 *
 * 输入
 * N(1 <= N <= 10^9 + 7)的值
 *
 * 输出
 * f(N) 除以 1000000007 的余数
 *
 * 输入样例
 * 10
 * 1000000007
 *
 * 输出样例
 * 88573
 * 4
 *
 * 超时
 * Created by zhouyanhui on 2019/11/30.
 */

import java.util.Scanner;

public class BadMain {
    private static final int M = 1000000007;
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
        long b = 1;
        long res = b;
        for (int i = 1; i <= n; i++) {
            b*=3;
            b%=M;
            res= (res + b) % M;
        }
        return res;
    }
}

