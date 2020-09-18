package mine.code.mioj._44_HowManyCubeNum;

/**
 * - 需要多少个立方数？
 * 序号：#44
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个数字N (0 \le N \le 1000000)N(0≤N≤1000000)，将 NN 写成立方数和的形式，求出需要的最少的立方数个数。
 *
 * 举例： 假设 N=17，可得 1+8+8 = 17，最少需要 3 个立方数，则输出 3 假设 N= 28，可得 1+1+1+1+8+8+8 = 28，需要 7 个立方数，又得 1+27=28，需要 2 个立方数，所以最少立方数为 2，则输出 2
 *
 * 输入
 * 一个正整数N (0 \le N \le 1000000)N(0≤N≤1000000)
 * 输出
 * 需要的最少的立方数个数（整型）
 *
 * 输入样例
 * 1
 * 17
 * 28
 * 32
 *
 * 输出样例
 * 1
 * 3
 * 2
 * 4
 *
 * 错误：贪心策略得不到最优解，如 32=3^3+1^3*5 = 2^3*4
 * Created by zhouyanhui on 2019/11/17.
 */
import java.util.*;

public class WrongMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int answer = solution(Long.valueOf(line));
            System.out.println(answer);
        }
    }

    private static int solution(long value) {
        if(value == 0){
            return 0;
        }
        int c = (int)Math.pow(value, 1 / 3.0);
        long v = (long) Math.pow(c + 1, 3);
        if(v > value){
            return 1 + solution(value - (long)Math.pow(c, 3));
        }else{
            return 1 + solution(value - v);
        }
    }
}

