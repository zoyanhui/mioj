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
 * 超时
 * Created by zhouyanhui on 2019/11/27.
 */

import java.util.Scanner;

public class BadMain3 {
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
        for (int i = n; i > n / 5; i--) {
            if(i > n / 2){
                twos += countNum2(i);
            }
            fives += countNum5(i);
        }
        return Math.min(twos, fives);
    }

    private static long countNum5(int n) {
        long c = 0;
        while (n > 0 && (n % 5) == 0) {
            c++;
            n /= 5;
        }
        return c * (c + 1) / 2;
    }

    private static long countNum2(int n) {
        long c = 0;
        while (n > 0 && (n & 0x1) == 0) {
            c++;
            n >>>= 1;
        }
        return c * (c + 1) / 2;
    }
}

