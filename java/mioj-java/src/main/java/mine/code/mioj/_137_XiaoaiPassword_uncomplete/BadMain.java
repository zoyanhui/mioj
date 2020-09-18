package mine.code.mioj._137_XiaoaiPassword_uncomplete;

/**
 * - 小爱密码
 * 序号：#137
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：80M
 * 描述
 * 小爱同学有一个智能密码锁。锁上有九位数字，小爱同学每次会给A,B,C,D,mod,n六个正整数。 题目是这样的：
 *
 * F(1) = A, F(2) = BF(1)=A,F(2)=B
 * F(n) = F(n-1) \cdot F(n-2) \cdot C^D (n \gt 2)F(n)=F(n−1)⋅F(n−2)⋅C
 * D
 *  (n>2)
 *
 * 现在小爱同学想计算出 G(n)G(n) 的值（G(n)为F(n)的前n项积），并用该值作为密码锁的密码。
 *
 * 由于结果过大，所以答案 G(n)%mod
 *
 * 输入
 * 多组数据。每组包含 6 个整数，分别代表 A, B, C, D, mod, n. (1<=A,B,C,D,mod,n<=1000000000)；数据组数不超过 2000.
 *
 * 输出
 * 输出 G(n)%mod 的值。
 *
 * 答案保留 9 位有效数字，不足则补 0.
 *
 * 输入样例
 * 2 2 2 2 1000 3
 * 7 9 3 4 6 5
 * 1 1 1000000000 1000000000 1000000000 1000000000
 *
 * 输出样例
 * 000000064
 * 000000003
 * 000000000
 *
 * 超时. 答案错误
 * Created by zhouyanhui on 2019/12/7.
 */

import java.util.Scanner;

public class BadMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            long solution = solution(line);
            System.out.printf("%09d\n", solution);
        }
    }

    private static int[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        int[] ret = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = Integer.valueOf(split[i]);
        }
        return ret;
    }

    private static long powMod(long a, long n, long mod){
        long s = a % mod, res = 1;
        while(n > 0){
            if((n & 1) == 1){
                res = (res * s) % mod;
            }
            s = (s * s) % mod;
            n >>>= 1;
        }
        return res;
    }

    private static long solution(String line) {
        int[] ints = splitToInts(line, " ");
        long A = ints[0], B = ints[1], C = ints[2], D = ints[3], mod = ints[4], n = ints[5];
        long f1 = A % mod, f2 = B % mod;
        long phim = phi(mod);
//        if(D > mod){
//            D = D % phim + phim;
//        }else {
//            D = D % phim;
//        }
        long mid = powMod(C, D, mod);
        mid = powMod(mid, n-2, mod);
        long G = (((f1 * f2) % mod) * mid) % mod;
        for (int i = 3; i <= n; i++) {
            long f = (f1 * f2) % mod;
            G = (G * f) % mod;
            f1 =f2;
            f2 = f;
        }
        return G;
    }

    private static long phi(long n){
        long sum = n;
        int m = (int)(Math.sqrt(n) + 1);
        for (int i = 2; i <= m; i++) {
            if(n % i == 0) {
                sum -= n / i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if(n > 1){
            sum -= sum / n;
        }
        return sum;
    }
}

