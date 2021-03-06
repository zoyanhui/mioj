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
 * (n>2)
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
 * 840187716 394382927 783099223 798440033 911647357 197551370
 * 1 1 9 2 6 4
 *
 * 输出样例
 * 000000064
 * 000000003
 * 000000000
 * 233779921
 * 000000003
 *
 * Created by zhouyanhui on 2019/12/7.
 */

import java.util.Scanner;

public class Main {
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

    private static long powMod(long a, long n, long mod) {
        long s = a % mod, res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
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
        if(n==1) return A%mod ;
        if(n==2) return A*B%mod;
        // sum(f1+……+fn) = f(n+2) - 1
        long m = phi(mod);
        long[] longs = powMatrix(n - 1, m);
        long suma = longs[1];
        long sumb = longs[0] - 1;
//        long sumc = suma  -1 ;// suma+ sumb - n;
        long sumc = suma+ sumb - n;  // TODO: 疑问
        sumc = sumc % m + m;
        long c = powMod(C, D %m + m, mod);
        long G = (powMod(A, suma, mod) * powMod(B, sumb, mod)) % mod;
        G = (G * powMod(c, sumc, mod)) % mod;
        return G;
    }

    private static long gcd(long a, long b) {
        if (a < b) {
            long temp = b;
            b = a;
            a = temp;
        }
        while (b > 0) {
            long c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private static long phi(long n) {
        long sum = n;
        long m = (long) (Math.sqrt(n));
        for (long i = 2; i <= m; i++) {
            if (n % i == 0) {
                sum = sum / i * (i - 1);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            sum = sum / n * (n - 1);
        }
        return sum;
    }

    private static long[] powMatrix(long n, long mod) {
        long a1 = 1, a2 = 1, a3 = 1, a4 = 0;
        long res1 = 1, res2 = 0, res3 = 0, res4 = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                long n1 = res1 * a1 % mod + res2 * a3 % mod;
                long n2 = res1 * a2 % mod + res2 * a4 % mod;
                long n3 = res3 * a1 % mod + res4 * a3 % mod;
                long n4 = res3 * a2 % mod + res4 * a4 % mod;
                res1 = n1 % mod;
                res2 = n2 % mod;
                res3 = n3 % mod;
                res4 = n4 % mod;
            }
            long n1 = a1 * a1 % mod + a2 * a3 % mod;
            long n2 = a1 * a2 % mod + a2 * a4 % mod;
            long n3 = a3 * a1 % mod + a4 * a3 % mod;
            long n4 = a3 * a2 % mod + a4 * a4 % mod;
            a1 = n1 % mod;
            a2 = n2 % mod;
            a3 = n3 % mod;
            a4 = n4 % mod;
            n >>>= 1;
        }
        return new long[] {(res1 + res2), (res3 + res4)};
    }
}

