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

import java.util.*;

public class BadMain {
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
        return editDistance(split[0], 0, split[1], 0);
    }

    private static int editDistance(String s1, int idx1, String s2, int idx2) {
        if(idx1 == s1.length()){
            return s2.length() - idx2;
        }
        if(idx2 == s2.length()){
            return s1.length() - idx1;
        }
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return editDistance(s1, idx1 + 1, s2, idx2 + 1);
        }
        int d1 = editDistance(s1, idx1 + 1, s2, idx2) ;
        int d2 = editDistance(s1, idx1, s2, idx2 + 1) ;
        int d3 = editDistance(s1, idx1 + 1, s2, idx2 + 1) ;
        return 1 + Math.min(Math.min(d1, d2), d3);
    }
}

