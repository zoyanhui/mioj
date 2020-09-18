package mine.code.mioj._141_XiaoaiPassword2_uncomplete;

/**
 * - 小爱密码 2.0
 * 序号：#141
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：32M
 * 描述
 * 小爱同学迎来了两周年，所以智能密码锁也升级为了 2.0 版本，但锁的密码仍需要根据小爱的线索才能得出。
 *
 * 锁上有九位字符，不足则补*（毕竟是 2.0 版本. YingYingYing）。小爱同学每次会给 n, mn,m 两个正整数。
 *
 * Fibonacci 数列可能大家都知道：
 *
 * \left\{ \begin{array}{lr} F(n) = 1 &amp; (0 \lt n \le 2)\\ F(n) = F(n-1) + F(n-2) &amp;(n &gt; 2) \\ \end{array} \right.
 * {
 * F(n)=1
 * F(n)=F(n−1)+F(n−2)
 * ​
 *
 * (0<n≤2)
 * (n>2)
 * ​
 *
 * 但是小爱同学觉得这对你来说 So easy~ 所以现在小爱同学想让你求出 Prime Fibonacci 数列 P 的第 N 位 (即该数列中不能被别的 Fibonacci 数整除的数)。 (P_1=2, P_2=3, P_3=5,P_4=13 \cdotsP
 * 1
 * ​
 *  =2,P
 * 2
 * ​
 *  =3,P
 * 3
 * ​
 *  =5,P
 * 4
 * ​
 *  =13⋯)
 *
 * 由于答案过大，所以答案 \frac{P_n}{3} \bmod m
 * 3
 * P
 * n
 * ​
 *
 * ​
 *  modm (题目保证\text{gcd}(3, m) = 1gcd(3,m)=1)
 *
 * 输入
 * 多组输入，每组数据输入 n, mn,m 两个正整数(1 \le n \le 500000, 4 \le m \le 10000000001≤n≤500000,4≤m≤1000000000，组数不大于 50000)
 *
 * 输出
 * 对于每组测试数据输出 \frac{P_n}{3} \bmod m
 * 3
 * P
 * n
 * ​
 *
 * ​
 *  modm
 * 答案保留 9 位字符，不足则补 *
 *
 * 输入样例
 * 2 5
 * 500000 1000000000
 *
 * 输出样例
 * ********1
 * 420970311  not 140323437
 *
 *
 * 思路;：若 f(q)为Fibonacci质数，则q为质数. 除f(3)=2, f(4)=3外
 * Created by zhouyanhui on 2019/12/8.
 */

import java.util.Arrays;
import java.util.Scanner;

public class SlowMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] s = line.split(" ", 2);
            int n = Integer.valueOf(s[0]);
            int m = Integer.valueOf(s[1]);
            long ans = solution(n, m);
            String ret = String.valueOf(ans);
            if(ret.length() < 9){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 9 - ret.length(); i++) {
                    sb.append("*");
                }
                ret = sb.toString() + ret;
            }
            System.out.println(ret);
        }
    }

    /**
     * 因为 gcd(3,m) = m, 所以3^-1 % m = 3^(m-2) % m，先欧拉降幂计算 3^(m-2) % m
     * @param n
     * @param m
     * @return
     */
    private static long solution(int n, int m) {
        int phim = phi(m);
        long multi = powMod(3, (m-2) % phim, m);
        long nPrime = calcPrimeFast(n);
        if(nPrime <= 3){
            nPrime+=1;
        }
        System.out.println(nPrime);
        long[] longs = powMatrix(nPrime-2, phim);
//        System.out.println(longs[0]);
        return (longs[0] * multi) % m;
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

    private static long calcPrimeFast(int n){
        boolean[] nums = new boolean[20*n];
        Arrays.fill(nums, true);
        nums[0] = false; nums[1] = false;
        for (int i = 2; i < nums.length ; i++) {
            if(!nums[i]){
                continue;
            }
            for (int j = i+i; j < nums.length; j+=i) {
                nums[j] = false;
            }
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]){
                k++;
                if(k == n){
                    return i;
                }
            }
        }
        return -1;
    }

    private static long calcPrime(int n){
        long[] vals = new long[Integer.max(n, 3)];
        vals[0] = 2;
        vals[1] = 3;
        vals[2] = 5;
        int k = 3, num = 7, gap = 2;
        while(k<n){
            boolean isPrime = true;
            for (int i = 0; i < k; i++) {
                long x = vals[i];
                if(x*x > num){
                    break;
                }
                if(num % x == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                vals[k++] = num;
            }
            gap = 6 - gap;
            num += gap;
        }
        return vals[n-1];
    }

    private static long calcPrimeSlow(long n) {
        int i = 2, j = 1;
        while(true){
            j++;
            if(j * j > i){
                n--;
                if(n == 0){
                    break;
                }
                j = 1;
            }
            if(i % j == 0){
                i++;
                j=1;
            }
        }
        return i;
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

    private static int phi(int n) {
        int sum = n;
        int m = (int) (Math.sqrt(n));
        for (int i = 2; i <= m; i++) {
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
}

