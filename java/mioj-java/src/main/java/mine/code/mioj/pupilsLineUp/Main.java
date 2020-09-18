package mine.code.mioj.pupilsLineUp;

/**
 * - 帮小学生排队
 * 序号：#18
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 用一个数组表示一群正在排队的小学生，每个小学生用一对整数 H, K 来表示：H 表示这个小学生的身高，K 表示这个小学生前面应该有 K 个人的身高 >= 他。
 *
 * 写一个算法，对给出的一组小学生计算出符合描述的正确排序。
 *
 * 输入
 * 输入为一组整数，以空格分隔：
 *
 * 第 1 个数字表示小学生的数量 n；
 * 从第 2 个数字起，后续的数字两两一组，分别代表每个小学生的 H 和 K 的值：H_1\text{ }K_1\text{ }H_2\text{ }K_2 \cdots H_n\text{ }K_nH
 *
 * 输出
 * 根据输入，按照题目要求对小学生进行排序，每个小学生对应的 H 和 K 值为一组，按组输出，数字间使用空格分隔。比如H_1&#x27;\text{ }K_1&#x27;\text{ }H_2&#x27;\text{ }K_2&#x27; \cdots H_n&#x27; \text{ }K_n&#x27;H
 *
 * 输入样例
 * 6 7 0 4 4 7 1 5 0 6 1 5 2
 *
 * 输出样例
 * 5 0 7 0 5 2 6 1 4 4 7 1
 * Created by zhouyanhui on 2019/11/6.
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
        int[] ints = splitToInts(line, " ");
        int n = ints[0];
        // 第一次冒泡
        for (int i = 1; i < n; i++) {
            int hIdx = i * 2 + 1;
            int kIdx = i * 2 + 2;
            while(hIdx > 2 && ints[hIdx] > ints[hIdx -2]){
                popHead(ints, hIdx, kIdx);
                hIdx -= 2;
                kIdx -= 2;
            }
            while (kIdx > 2 && ints[kIdx] < ints[kIdx - 2] && ints[hIdx] == ints[hIdx - 2]){
                popHead(ints, hIdx, kIdx);
                hIdx -= 2;
                kIdx -= 2;
            }
        }
        // 第二次冒泡
        for (int i = 1; i < n; i++) {
            int hIdx = i * 2 + 1;
            int kIdx = i * 2 + 2;
            while(kIdx > 2 && ints[kIdx] < kIdx/2 - 1){
                popHead(ints, hIdx, kIdx);
                hIdx -= 2;
                kIdx -= 2;
            }
        }
        return toString(ints);
    }

    private static String toString(int[] ints) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < ints.length; i++) {
            stringBuilder.append(ints[i]).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static void popHead(int[] ints, int hIdx, int kIdx) {
        int temp = ints[hIdx - 2];
        ints[hIdx - 2] = ints[hIdx];
        ints[hIdx] = temp;
        temp = ints[kIdx - 2];
        ints[kIdx - 2] = ints[kIdx];
        ints[kIdx] = temp;
    }

    private static int[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        int[] vals = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            vals[i] = Integer.valueOf(split[i]);
        }
        return vals;
    }
}

