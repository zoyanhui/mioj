package mine.code.mioj._43_NormalizeNumber;

/**
 * 寻找归一数字
 * 序号：#43
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 有一类正整数我们叫做归一数字，对于任意一个归一数字 N，满足以下特性：
 *
 * N 的每一位的平方和组成一个数，新数字的平方和再组成一个新数字，如此往复运算，直到最终结果为 1。
 *
 * 若一个数字能最终归一成 1，则该数字为归一数字，否则不是归一数字。
 *
 * 举例： 82可以分解为8^2 + 2^2 = 68，68继续分解为6^2 + 8^2 = 100，100可以分解为1^2 + 0^2 + 0^2 = 1。所以82可以归一。
 *
 * 输入
 * 一个正整数 N（0 < N < 100000000）
 *
 * 输出
 * 输出N 是否为归一数的判断结果，若是则返回 'true'，否则返回 'false'（均为字符串）。
 *
 * 输入样例
 * 1
 * 82
 * 50
 *
 * 输出样例
 * true
 * true
 * false
 *
 * Created by zhouyanhui on 2019/11/17.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            boolean answer = solution(line);
            System.out.println(answer);
        }
    }

    private static boolean solution(String line) {
        long ss = 0;
        for (int i = 0; i < line.length(); i++) {
            ss += Math.pow(line.charAt(i) - '0', 2);
        }
        if(ss == 1){
            return true;
        }
        return isNormal(ss);
    }

    private static boolean isNormal(long ss) {
        if(ss == 10 || ss == 70){
            return true;
        }
        if(ss < 100 && ss % 10 == 0){
            return false;
        }
        if(ss < 10){
            return ss == 1 || ss == 7;
        }
        long next = 0;
        while(ss > 0){
            next += Math.pow(ss % 10, 2);
            ss/=10;
        }
        return isNormal(next);
    }
}

