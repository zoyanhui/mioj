package mine.code.mioj._57_PlayStrings;

/**
 * - 玩转字符串
 * 序号：#57
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 是的，又是字符串。
 *
 * 规定两种操作：
 *
 * 一种是在字符串末尾加字符 A。
 * 另一种是先反转整个字符串，再给字符串末尾加上字符 B。
 * 给出一个初始串 S，一个终点串 T。问能否通过这两个操作从 S 变换到 T。如果可以输出 1（弱初始串和终点串相同，视为可以变换），不可以输出 0。
 *
 * 输入
 * 由英文空格分隔的两个字符串，每个字符串只由 AB 两个字符组成
 *
 * 输出
 * 1 或 0，表示可以变换，或不可以变换。
 *
 * 输入样例
 * AB ABB
 * AAAB AAABA
 * AABB BBAAB
 *
 * 输出样例
 * 0
 * 1
 * 1
 *
 *
 * recursive: 超时
 *
 *
 * Created by zhouyanhui3 on 19-11-21.
 */

import java.util.Scanner;

public class BadMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int answer = solution(line);
            System.out.println(answer);
        }
    }

    static class Str{
        Str(String s, boolean r){
            this.str = s;
            this.reverse = r;
        }
        String str;
        boolean reverse = false;
    }

    private static int solution(String line) {
        String[] split = line.split(" ");
        Str s = new Str(split[0], false);
        String t = split[1];
        return play(s, t);
    }

    private static int play(Str s, String t) {
        if(equal(s, t)){
            return 1;
        }
        if(s.str.length() > t.length()){
            return 0;
        }
        if(s.reverse){
            if(play(new Str("A" + s.str, true), t) == 1){
                return 1;
            }
            if(play(new Str(s.str + "B", false), t) == 1){
                return 1;
            }
        }else{
            if(play(new Str(s.str + "A", false), t) == 1){
                return 1;
            }
            if(play(new Str("B" + s.str, true), t) == 1){
                return 1;
            }
        }

        return 0;
    }

    private static boolean equal(Str s, String t) {
        if(!s.reverse) {
            return s.str.equalsIgnoreCase(t);
        }
        if(s.str.length() != t.length()){
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) != s.str.charAt(t.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}

