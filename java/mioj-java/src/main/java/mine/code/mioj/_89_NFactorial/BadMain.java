package mine.code.mioj._89_NFactorial;

/**
 * - N!
 * 序号：#89
 * 难度：困难
 * 时间限制：1500ms
 * 内存限制：64M
 * 描述
 * 给定一个整数N，求N!的末尾有多少个0.
 *
 * 输入
 * 输入为一个整数N，1 <= N <= 1000000000.
 *
 * 输出
 * 输出为N!末尾0的个数
 *
 * 输入样例
 * 3
 * 60
 * 100
 * 1024
 * 23456
 * 8735373
 * 1000000000
 *
 * 输出样例
 * 0
 * 14
 * 24
 * 253
 * 5861
 * 2183837
 * 249999998
 *
 * 错误： java.lang.OutOfMemoryError: Java heap space
 * Created by zhouyanhui on 2019/11/27.
 */

import java.util.Scanner;

public class BadMain {
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
        long twos = 0;
        long fives = 0;
        boolean[] dp2 = new boolean[n+1];
        boolean[] dp5 = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            twos += calcTwos(i, 2, n, dp2);
            fives += calcTwos(i, 5, n, dp5);
        }
        return Math.min(twos, fives);
    }

    private static long calcTwos(int i, int d, int n, boolean[] dp) {
        int count = 0;
        if(!dp[i]){
            long cur= countNum(i, d);
            count += cur;
            dp[i] = true;
            int k = i * d; // 错误：溢出
            while(k <= n){
                dp[k]=true;
                cur++;
                count+=cur;
                k*=d;
            }
        }
        return count;
    }

    private static long countNum(int n, int d) {
        long c = 0;
        while(n > 0 && n % d == 0){
            c++;
            n/=d;
        }
        return c;
    }
}

