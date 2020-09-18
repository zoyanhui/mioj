package mine.code.mioj._30_ReverseBitInteger;

/**
 * - 反向位整数
 * 序号：#30
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 输入32位无符号整数，输出它的反向位。 例，输入4626149（以二进制表示为00000000010001101001011011100101），返回2808701440（以二进制表示为10100111011010010110001000000000）。
 *
 * 输入
 * 一个无符号32位整数字符串
 *
 * 输出
 * 一个无符号32位整数，为输入整数的反向位
 *
 * 输入样例
 * 4626149
 *
 * 输出样例
 * 2808701440
 * Created by zhouyanhui3 on 19-11-11.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            long answer = solution(line);
            System.out.println(answer);
        }
    }

    private static long solution(String line) {
        long src = Long.valueOf(line);
        long dst = 0l;
        int i = 31;
        while(src > 0){
            dst |= (src & 0x01) << i;
            i--;
            src >>>= 1;
        }
        return dst;
    }
}

