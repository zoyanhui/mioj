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
 * 超时
 * Created by zhouyanhui on 2019/11/25.
 */

import java.util.Scanner;

public class BadRecursiveMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
        }
    }

    private static int solution(String line) {
        if(line.length() < 2){
            return 0;
        }
        return calc(line, 0 ,'c');
    }

    private static int calc(String line, int idx, char last) {
        if(idx == line.length()){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        char c = line.charAt(idx);
        if(c == '?'){
            if(last == 'a'){
                min = Math.min(calc(line, idx + 1, 'a') + 1, min);
                min = Math.min(calc(line, idx + 1, 'b'), min);
            }else if (last == 'b'){
                min = Math.min(calc(line, idx + 1, 'a'), min);
                min = Math.min(calc(line, idx + 1, 'b') + 1, min);
            }else{
                min = Math.min(calc(line, idx + 1, 'a'), min);
                min = Math.min(calc(line, idx + 1, 'b'), min);
            }
        }else{
            if(c == last){
                min = 1 + calc(line, idx + 1, last);
            }else{
                min = calc(line, idx + 1, c);
            }
        }
        return min;
    }
}

