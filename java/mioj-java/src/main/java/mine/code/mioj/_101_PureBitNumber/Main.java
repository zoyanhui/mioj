package mine.code.mioj._101_PureBitNumber;

/**
 * - 纯位数
 * 序号：#101
 * 难度：非常难
 * 时间限制：2000ms
 * 内存限制：20M
 * 描述
 * 在数学中，所谓“纯位数”是指由相同位元重复而组成的自然数。比如在十进制中，1，22，333，555 都是纯位数。 很显然，15 在十进制中不是一个纯位数，但是在二进制 15(10) = 1111(2) 却是一个纯位数。
 *
 * 一个显然的事实是，对于正整数 N，其在 N+1 进制中必然是一个一位数，也就必然是个纯位数。
 *
 * 对于一个正整数 N，试找出使其成为纯位数的最小进制 K。
 *
 * 输入
 * 一个正整数 N (0 < N < 10^8)
 *
 * 输出
 * 使 N 为纯位数的最小进制 K
 *
 * 输入样例
 * 22
 * 15
 *
 * 输出样例
 * 10
 * 2
 *
 *
 * Created by zhouyanhui on 2019/11/30.
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
        for (int k = 2; k <= n+1; k++) {
            if(isPureBit(n, k)){
                return k;
            }
        }
        return n+1;
    }

    private static boolean isPureBit(int n, int k) {
        int m = n % k;
        while (n > 0 && n % k == m){
            n /= k;
        }
        return n == 0;
    }
}

