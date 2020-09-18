package mine.code.mioj._24_pirates;

/**
 * - 海盗分赃
 * 序号：#24
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 一箱失落多年的宝藏被两位海盗找到，宝箱里的一堆大小与重量各不相同的金块。 他们称出了每个金块的重量，但是如何如何平分这些金子却令他们十分头疼。 程序员们，你能告诉两位海盗，他们能否平分这箱宝藏么？
 *
 * 假设宝箱里有三块金子，重量分别为：1,2,3。则他们可以平分这些金子：1+2=3 又假设宝箱里有四块金子，重量分别为：1,2,6,4。则他们无法找到平分的方法
 *
 * 输入
 * 一行由逗号分隔的 N 个无序正整数（0<N<100），每个正整数表示每块金子的重量 W（0<W<10000）。
 *
 * 输出
 * 字符串true或false，表示海盗们能否平分这些金子
 *
 * 输入样例
 * 1,2,3
 * 1,2,6,4
 * 1,6,8,3,5,9
 * 10,5,8,6,20,13,7,11
 *
 * 输出样例
 * true
 * false
 * true
 * true
 * Created by zhouyanhui on 2019/11/9.
 *
 *
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

    private static int[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        int[] ret = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = Integer.valueOf(split[i]);
        }
        return ret;
    }

    private static boolean solution(String line) {
        int[] ints = splitToInts(line, ",");
        if(ints.length <= 1){
            return false;
        }
        int sum = 0;
        for (Integer anInt : ints) {
            sum+= anInt;
        }
        if((sum & 0x01) == 1){
            return false;
        }
        byte[] sFlags = new byte[1000000];
        sFlags[0] = 0x10;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < sFlags.length; j++) {
                byte sFlag = sFlags[j];
                int flag = sFlag & 0x11;
                if(flag == 0){
                    continue;
                }
                if(flag > 1){
                    sFlags[j] = 0x10;
                    sFlags[j + ints[i]] += 1;
                }
                sFlags[j] = 0x10;
            }
            if((sFlags[sum/2] & 0x11) > 0){
                return true;
            }
        }
        return false;
    }
}

