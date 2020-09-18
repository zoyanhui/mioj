package mine.code.mioj._23_FindTheNInNumberSequnce2;

/**
 * - 找到第 N 个数字 II
 * 序号：#23
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 假如有一组字符串符合如下规律：
 * S_1 = 1 \\\\ S_2 = 12 \\\\ S_3 = 123 \\\\ S_4 = 1234 \\\\ \cdots \\\\ S_9 = 123456789 \\\\ S_{10} = 12345678910 \\\\ S_{11} = 1234567891011 \\\\ \cdots \\\\ S_{18} = 123456789101112131415161718 \\\\ \cdots
 * (对于S_nS
 * n
 * ​
 *  来说，将从1到nn的数字拼接到一起)
 *
 * 现在我们把所有的字符串拼接起来，组成一个无限长的字符串 S = 1121231234 \cdots 12345678910111213 \cdotsS=1121231234⋯12345678910111213⋯ 你能找出该字符串的第nn位数字是多少吗?
 *
 * 输入
 * 一个整数（1 < 整数 < 10^{15}10
 * 15
 *  ），表示所求的位数是多少位
 *
 * 输出
 * 一个整数，表示该位上的数字是多少
 *
 * 输入样例
 * 1
 * 6
 * 7
 * 123456789
 *
 * 输出样例
 * 1
 * 3
 * 1
 * 3
 *
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
        if(N <= 0){
            return -1;
        }
        if(N == 1){
            return 1;
        }
        int i = 1;
        long si = 1;
        long n = si;
        while(true){
            i++;
            si += lenOfNum(i);
            n += si;
            if(n >= N){
                break;
            }
        }
        int idx = (int)(N - n + si);
        if(idx < 10){
            return idx;
        }
        int j = 1;
        int cj = 9;
        int sum = cj;
        while (true){
            j++;
            cj = 9 * (int)Math.pow(10, j -1) * j;
            sum += cj;
            if(sum >= idx){
                break;
            }
        }
        // j 位数组合中的第 r 个
        int r = idx - sum + cj;
        // 所在的j位数 num
        int c = (int)Math.pow(10, j -1);
        int num = c + (r - 1)/j ;
        // num中的第k位
        int k = r % j;
        if(k == 0){
            return num % 10;
        }
        while(k < j){
            num /= 10;
            k++;
        }
        return num % 10;
    }

    private static long lenOfNum(int num) {
        int i = 0;
        while(num > 0){
            i++;
            num/=10;
        }
        return i;
    }
}
