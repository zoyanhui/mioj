package mine.code.mioj._42_StringReplace;

/**
 * - 字符串替换
 * 序号：#42
 * 难度：非常难
 * 时间限制：5000ms
 * 内存限制：10M
 * 描述
 * 给出两个字符串S1、S2，对S1进行插入、删除、替换的操作，每次只能操作一个字符，最少操作多少步，使其等于S2。
 *
 * 举例： S1 = abc, S2 = badc，abc插入字符b变为 babc，字符b替换为字符d变为 badc，估最少操作两步。
 *
 * 输入
 * 两个字符串S1、S2，以逗号（,）分开，操作S1使其等于S2
 *
 * 输出
 * 一个整数，表示最少操作步数
 *
 * 输入样例
 * abc,badc
 *
 * 输出样例
 * 2
 *
 * 超时
 * Created by zhouyanhui on 2019/11/17.
 */

import java.util.Scanner;

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
        String[] split = line.split(",", 2);
        String s1 = split[0];
        String s2 = split[1];
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        dp[0][0] = 0;
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i+1] = i+1;
        }
        for (int i = 0; i < s1.length(); i++) {
            dp[i+1][0] = i+1;
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = min(dp[i][j+1], dp[i+1][j], dp[i][j]) + 1;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}

