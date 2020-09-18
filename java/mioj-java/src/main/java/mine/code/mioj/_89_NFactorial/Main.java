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
 * Created by zhouyanhui on 2019/11/27.
 */

import java.util.*;

public class Main {
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
        long[] pow2 = new long[30];
        long k = 2;
        for (int i = 0; i < 30; i++) {
            pow2[i] = k;
            k *= 2;
        }
        long[] pow5 = new long[13];
        k = 5;
        for (int i = 0; i < 13; i++) {
            pow5[i] = k;
            k *= 5;
        }
        int twos = 0, fives = 0;
        long last = 0;
        for (int i = pow2.length-1; i >= 0; i--) {
            long p2 = pow2[i];
            long cur = n / p2;
            if(cur > 0){
                twos += (cur - last) * (i + 1);
            }
            last = cur;
        }
        last = 0;
        for (int i = pow5.length-1; i >= 0; i--) {
            long p5 = pow5[i];
            long cur = n / p5;
            if(cur > 0){
                fives += (cur - last) * (i + 1);
            }
            last = cur;
        }
        return Math.min(twos, fives);
    }
}

