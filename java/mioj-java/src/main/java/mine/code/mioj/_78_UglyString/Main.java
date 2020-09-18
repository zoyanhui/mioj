package mine.code.mioj._78_UglyString;

/**
 * - 字符串拼颜值
 * 序号：#78
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 现在是拼颜值的时代。 字符串也是如此，如果相邻字符相同出现次数越多 (即 s[i] == s[i + 1] )，那么字符串越丑，反之，颜值就越高。 我们定义字符串的丑陋度计算方法：如果对于两个相邻字符相等，加1分。否则不加分。 现在有一个由 a, b 和 ? 组成的字符串，计算丑陋度前需要先将字符串中的所有 ? 替换成 a 或 b。请输出能得到最低的字符串丑陋度。
 *
 * 举例： ?? 可表示为 ab，最低得分为0 a?a 可表示 aba，最低得分为0 abaa ，有一处相邻相等，最低得分为1
 *
 * 注意：最终分数越高表示字符串越丑陋
 *
 * 输入
 * 由a, b, ?组成的字符串，长度为1 ~ 50
 *
 * 输出
 * 字符串能得到丑陋分数的最低值
 *
 * 输入样例
 * ??
 * a?a
 * abaa
 * ??????????????????????????????????????????????????
 *
 * 输出样例
 * 0
 * 0
 * 1
 * 0
 *
 * Created by zhouyanhui on 2019/11/25.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
        }
    }

    private static int solution(String line) {
        int len = line.length();
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        char last = line.charAt(0);
        if(last == 'a'){
            dp[0][0] = 0;
            dp[0][1] = len;
        }else if(last == 'b'){
            dp[0][0] = len;
            dp[0][1] = 0;
        }else{
            dp[0][0] = 0;
            dp[0][1] = 0;
        }
        for (int i = 1; i < len; i++) {
            char c = line.charAt(i);
            if(c == '?'){
                if(last == 'a'){
                    dp[i][0] = dp[i-1][0] + 1;
                    dp[i][1] = dp[i-1][0];
                }else if (last == 'b'){
                    dp[i][0] = dp[i-1][1];
                    dp[i][1] = dp[i-1][1] + 1;
                }else{
                    dp[i][0] = Math.min(dp[i-1][0] + 1, dp[i-1][1]);
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1] + 1);
                }
            }else{
                if(last == c){
                    if(last == 'a'){
                        dp[i][0] = dp[i-1][0] + 1;
                        dp[i][1] = len;
                    }else{
                        dp[i][0] = len;
                        dp[i][1] = dp[i-1][1] + 1;
                    }
                }else {
                    if (last == 'a') {
                        dp[i][0] = len;
                        dp[i][1] = dp[i-1][0];
                    } else if (last == 'b') {
                        dp[i][0] = dp[i-1][1];
                        dp[i][1] = len;
                    } else {
                        if(c == 'a') {
                            dp[i][0] = Math.min(dp[i-1][0] + 1, dp[i-1][1]);
                            dp[i][1] = len;
                        }else{
                            dp[i][0] = len;
                            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1] + 1);
                        }
                    }
                }
            }
            last = c;
        }
        if(last == 'a'){
            return dp[len-1][0];
        }else if(last == 'b'){
            return dp[len-1][1];
        }else{
            return Math.min(dp[len-1][0], dp[len-1][1]);
        }
    }
}

