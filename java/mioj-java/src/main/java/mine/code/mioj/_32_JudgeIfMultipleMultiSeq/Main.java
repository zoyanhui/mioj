package mine.code.mioj._32_JudgeIfMultipleMultiSeq;

/**
 *  判断是否为连乘数字串
 * 序号：#32
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个字符串S，判断S是否为连乘字符串。
 *
 * 连乘字符串定义为： 字符串拆分成若干数字，后面的数字（从第三个数字开始）为前面2个数字的乘积。
 *
 * 例如：
 *
 * 122，可以拆成{1|2|2}，有 1 * 2=2
 * 1122242，可以拆成{11|22|242}，有11 * 22=242
 * 1224832256，可以拆成{1|2|2|4|8|32|256}，有1 * 2 = 2，2 * 2 = 4，2 * 4 = 8，4 * 8 = 32，8 * 32 = 256。
 * 若是连乘字符串，则输出 true，否则输出 false。(PS:不考虑乘以0)
 *
 * 输入
 * 一个正整数字符串
 *
 * 输出
 * 字符串true或者false，表示是否可以拆成连乘数字。
 *
 * 输入样例
 * 122
 * 113
 * 1122242
 * 1224832256
 *
 * 输出样例
 * true
 * false
 * true
 * true
 *
 * Created by zhouyanhui3 on 19-11-12.
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
        for (int i = 1; i <= line.length() - 2; i++) {
            for (int j = i; j <= line.length() - 2; j++) {
                long first = Long.valueOf(line.substring(0, i));
                long sencond = Long.valueOf(line.substring(i, j+1));
                int pre = j;
                while(true){
                    long next = first * sencond;
                    String nextStr = String.valueOf(next);
                    int nextLen = nextStr.length();
                    int nextIdx = nextLen + pre;
                    if(nextIdx >= line.length()){
                        break;
                    }
                    if(!line.substring(pre+1, nextIdx + 1).equalsIgnoreCase(nextStr)){
                        break;
                    }
                    if(nextIdx == line.length() - 1){
                        return true;
                    }
                    pre = nextIdx;
                    first = sencond;
                    sencond = next;
                }

            }
        }
        return false;
    }
}
