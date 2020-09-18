package mine.code.mioj._22_FindTheNInNumberSequence;

/**
 * - 找到第 N 个数字
 * 序号：#22
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 假如有一组字符串符合如下规律：
 *
 * S1 = 1
 * S2 = 12
 * S3 = 123
 * .........
 * S9 = 123456789
 * S10 = 1234567898
 * S11 = 12345678987
 * ............
 * S17 = 12345678987654321
 * S18 = 123456789876543212
 * ..................
 * (对于Sn来说，长度为n，每个串从1开始，增长到9再降到1，再从1开始增长，不包含0)
 *
 * 现在我们把所有的字符串拼接起来，组成一个无限长的字符串
 *
 * S = 1121231234.......123456789876543212345678987.......
 * 你能找出该字符串的第n位数字是多少吗?
 *
 * 输入
 * 一个整数（长度 < 20 位），表示所求的位数是多少位
 *
 * 输出
 * 一个整数，表示该位上的数字是多少
 *
 * 输入样例
 * 1
 * 6
 * 7
 *
 * 输出样例
 * 1
 * 3
 * 1
 * Created by zhouyanhui on 2019/11/9.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int answer = solution(line);
            System.out.println(answer);
        }
    }

    private static int solution(String line) {
        long N = Long.valueOf(line);
        long k = (long)(Math.sqrt(N) * Math.sqrt(2) - 1);
        long cur = k * (k + 1) / 2;
        while (true){
            if(cur >= N){
                break;
            }
            k++;
            cur += k;
        }
        long idx = N - cur + k; // idx of Sk
        long group = idx / 8;
        int r = (int)(idx % 8);
        if((group & 0x1) == 1){
             if(r == 0){
                 return 8;
             }
             return 10 - r;
        }else{
            if(r == 0){
                return 2;
            }
            return r;
        }
    }
}

