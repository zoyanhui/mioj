package mine.code.mioj._60_UpDownString;

/**
 * - 上上下下的字符串
 * 序号：#60
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 字符串 S 由字符 + 和 - 构成。字符串 D 是一个数字字符串，其长度比 S 要大 1，其格式要求如下：
 *
 * D 中不包含数字 0；
 * D 中必须包含数字 1，且最大数字不大于 D 的长度；
 * D 中的数字不重复出现。
 * 根据 S，可以转换得到唯一的 D，S 与 D 的关系为：
 *
 * S[i] 为 + 表示 D[i] < D[i+1];
 * S[i] 为 - 表示 D[i] > D[i+1]，且 D[i] - D[i+1] = 1.
 * 现给出字符串 S 的值，请构造出合法的字符串 D 。 如输入 +-+-，输出 13254，因为 1 < 3 > 2 < 5 > 4，符合增减增减（+-+-）的趋势。
 *
 * 输入
 * 只由 + 和 - 构成的一个字符串。
 *
 * 输出
 * 一个不含0且没有重复数字的字符序列。
 *
 * 输入样例
 * ++++
 * ----
 * +-+-++
 *
 * 输出样例
 * 12345
 * 54321
 * 1325467
 *
 *
 *
 *
 * NOTE:提示：#################
 * 减号连接的位置(数字)逆序：   1 + 3 - 2 + 6 - 5 - 4 + 7
 *
 * ############################
 *
 * Created by zhouyanhui3 on 19-11-21.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String answer = solution(line);
            System.out.println(answer);
        }
    }

    private static String solution(String line) {
        int max = line.length() + 1;
        int pos[] = new int[max];
        int p = -1;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '-'){
                if(p < 0){
                    p = i;
                }else{
                    continue;
                }
            }else{
                if(p >= 0){
                    int c = p;
                    for (int j = i; j >= p; j--) {
                        pos[c++] = j;
                    }
                    p = -1;
                }else{
                    pos[i] = i;
                }
            }
        }
        if(p >= 0){
            int c = p;
            for (int j = line.length(); j >= p; j--) {
                pos[c++] = j;
            }
        }else {
            pos[line.length()] = line.length();
        }
        int[] res = new int[max];
        for (int i = 0; i < pos.length; i++) {
            res[pos[i]] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i] + 1);
        }
        return sb.toString();
    }
}

