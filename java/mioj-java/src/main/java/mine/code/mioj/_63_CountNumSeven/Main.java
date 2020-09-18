package mine.code.mioj._63_CountNumSeven;

/**
 * - 数7游戏
 * 序号：#63
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 数 7 游戏，从 1 开始报数，遇到 7 的倍数以及含 7 的数字直接 pass。 写出一个算法，计算第 N 个数是多少。
 *
 * 输入
 * 一个正整数 N，表示需要计算的数为第 N 个数，1 <= N <= 100000。
 *
 * 输出
 * 第 N 个数的数值。
 *
 * 输入样例
 * 1
 * 7
 * 8
 * 24
 * 123
 * 3467
 * 88888
 * 99999
 *
 * 输出样例
 * 1
 * 8
 * 9
 * 30
 * 169
 * 5493
 * 168223
 * 198026
 *
 * Created by zhouyanhui on 2019/11/23.
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

    private static int solution(int n) {
        int k = 0;
        for (int i = 0; i < n; ) {
            k++;
            if(k % 7 == 0){
                continue;
            }
            if(containsSeven(k)){
                continue;
            }
            i++;
        }
        return k;
    }

    private static boolean containsSeven(int n){
        while(n > 0){
            if(n % 10 == 7){
                return true;
            }
            n/=10;
        }
        return false;
    }
}

