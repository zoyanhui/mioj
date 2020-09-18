package mine.code.mioj._96_NthUlgyNumber;

/**
 * - 第N个丑数
 * 序号：#96
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 输入
 * 输入一个正整数N，0<N<10000
 *
 * 输出
 * 输出一个正整数S，S为第N个丑数
 *
 * 输入样例
 * 1
 * 2
 * 7
 * 10
 * 100
 * 10000
 *
 * 输出样例
 * 1
 * 2
 * 8
 * 12
 * 1536
 * 288325195312500000
 *
 *
 * Created by zhouyanhui on 2019/11/30.
 */

import java.util.Scanner;

public class BetterMain {
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
        long[] res = new long[n];
        res[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int m = 1; m < n; m++) {
            long two = res[i] * 2;
            long three = res[j] * 3;
            long five = res[k] * 5;
            if(two <= three && two <= five){
                i++;
                res[m] = two;
            }
            if(three <= two && three <= five){
                j++;
                res[m] = three;
            }
            if(five <= two && five <= three){
                k++;
                res[m] = five;
            }
        }
        return res[n-1];
    }
}

