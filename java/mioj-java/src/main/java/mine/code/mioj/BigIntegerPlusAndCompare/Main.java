package mine.code.mioj.BigIntegerPlusAndCompare;

/**
 * - 大数的加法运算与大小判断
 * 序号：#19
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 对于给定的算术表达式，按规则输出计算结果，仅包含加法和大小判断。
 *
 * 输入
 * 一行字符串，为加号、大于、小于( + < > ) 连接的两个不限大小的非负整数。
 *
 * 输出
 * 当符号为 + 时, 计算两个数相加的和, 并以字符串格式返回； 当符号为 < 时, 如果左数小于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N； 当符号为 > 时, 如果左数大于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N。
 *
 * !!!请同学们尽量使用算法来解决这个问题
 *
 * 输入样例
 * 972919822976663297>74058
 * 875098336507333719633571722631534917759993913379786689>53558270653237768027942884431075534537929401567824882097903948774409200
 * 7625022925148127196027859399571498914361+790786706794530
 *
 * 输出样例
 * Y
 * N
 * 7625022925148127196027860190358205708891
 * Created by zhouyanhui3 on 19-11-7.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String answer = solution(line);
            System.out.println(answer);
        }
    }

    private static String solution(String line) {
        int split = -1;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c >= '0' && c <= '9'){
                continue;
            }
            split = i;
            break;
        }
        if(split < 0){
            return "input wrong";
        }
        char op = line.charAt(split);
        if(op == '+'){
            return plus(line.substring(0, split), line.substring(split + 1));
        }
        int comp = compare(line, 0, split-1, split+1, line.length() -1);
        if(op == '>'){
            return comp > 0 ? "Y" : "N";
        }else{
            return comp < 0 ? "Y" : "N";
        }
    }

    private static int compare(String line, int num1Start, int num1End, int num2Start, int num2End) {
        int len1 = num1End - num1Start + 1;
        int len2 = num2End - num2Start + 1;
        if(len1 < len2){
            return -1;
        }
        if(len1 > len2){
            return 1;
        }
        for (int i = num1Start, j=num2Start; i <=num1End; i++, j++) {
            if(line.charAt(i) > line.charAt(j)){
                return 1;
            }
            if(line.charAt(i) < line.charAt(j)){
                return -1;
            }
        }
        return 0;
    }

    private static String plus(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int flag = 0;
        if(num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int j = num1.length() - 1;
        for (int i = num2.length() -1; i >= 0; i--, j--) {
            int n = num2.charAt(i) - '0' + num1.charAt(j) - '0' + flag;
            result.append((char)(n % 10 + '0'));
            flag = n / 10;
        }
        for (; j >= 0; j--) {
            int n = num1.charAt(j) - '0' + flag;
            result.append((char)(n % 10 + '0'));
            flag = n / 10;
        }
        if(flag > 0){
            result.append((char)(flag + '0'));
        }
        return result.reverse().toString();
    }
}

