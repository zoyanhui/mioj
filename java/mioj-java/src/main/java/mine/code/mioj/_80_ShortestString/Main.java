package mine.code.mioj._80_ShortestString;

/**
 * - 最短字符串
 * 序号：#80
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 有一个字符串S，是由字符串T变换而来的。变换规则如下： 字符串S起始为空字符串，每次取T任意大小的前缀连接到S的末尾，形成新的S。 比如T=abcad，S起始为空 第一步：取T的前缀abcad加到S末尾，S=abcad 第二步：取T的前缀abc加到S末尾，S=abcadabc 第三步：取T的前缀abcad加到S末尾，S=abcadabcabcad
 *
 * 现在告诉你字符串S，请你给出可以变换成S的长度最小的字符串T
 *
 * 输入
 * 输入一个非空字符串S，字符串S的长度L<100000,只包含小写字母 例如abcadabcabcad
 *
 * 输出
 * 一个字符串T
 *
 * 输入样例
 * abcadabcabcad
 * abcababcd
 * aaaaaa
 * aabcbcabcd
 * abcabcdab
 * abcababcd
 * abcdabcababcd
 * afibmhqaacxapiwttscdbfobtgtzdnuhgrafibmhqaacxapiwttscdbfobtgtzdnuhgrierafibmhqaacxapiwttscdbfobtgtzdnuhgrierhd
 * ikqxrniiewvikqxrniiewvujiucjzikqxrniiewvujiucjikqxrniiewvujiucjzpikqxrniiewvujiucjzpfmgikqxrniikqxrniikqxrniiewvujiucjzpfmghwthikqxrniiewvujiucjzpfmghwthnmocmqjixf
 *
 *
 * 输出样例
 * abcad
 * abcd
 * a
 * abcbcabcd
 * abcd
 * abcd
 * abcd
 * afibmhqaacxapiwttscdbfobtgtzdnuhgrierhd
 * ikqxrniiewvujiucjzpfmghwthnmocmqjixf
 *
 *
 * Created by zhouyanhui3 on 19-11-26.
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

    private static String solution(String line) {
        int[] lcs = new int[line.length()+1];
        lcs[0] = -1;
        int k = -1;
        int maxLen = 0;
        int start = 0, end = 0, newStart = -1;
        for (int i = 0; i < line.length();) {
//            System.out.println(Arrays.toString(lcs) + "\t"
//                    + "end:" + end + " start:" + start + " newStart:" + newStart
//                    + " i:" + i + " k:" + k
//                    + " line[k]:" + (k >= 0 ? line.charAt(k) : '0') + " line[i]:" + line.charAt(i));
            if(k == -1){
                if(end >= 0){
                    end = -1;
                }
                k += start + 1;
                i++;
                lcs[i] = k;
            }else if(line.charAt(k) == line.charAt(i)){
                k++;
                i++;
                lcs[i] = k;
                if(k == start + 1 && i >= start + maxLen){
                    newStart = i - 1;
                    if(end < 0) {
                        end = newStart;
                    }
                }
            }else{
                if(newStart >= 0 && end >= 0){
                    if(i - newStart >= end - start) {
                        lcs[newStart] = -1;
                        k = -1;
                        start = newStart;
                        end = -1;
                        i = start;
                    }else{
                        newStart = -1;
                    }
                }else {
                    k = lcs[k];
                    if(k == start + 1 && i >= start + maxLen){
                        newStart = i - 1;
                        if(end < 0) {
                            end = newStart;
                        }
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(lcs));
        if(end > 0) {
            return line.substring(start, end);
        }else if(start > 0){
            return line.substring(start);
        }else{
            return line;
        }
    }
}
