package mine.code.mioj._66_SaveOnElectricity;

/**
 * - 节约用电
 * 序号：#66
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 为了节约用电，星际争霸里的神族（Protoss）每天需要在战斗结束后关闭神族水晶（Pylon）的电源。 神族的电源开关是由一个巨大的网络与水晶连接的，每个水晶对应一个开关，其中第 i 个开关会同时改变第 i 个水晶，第 2 * i 个水晶以及第 3 * i 个水晶... 的状态（水晶和开关的编号都从 1 开始）。 现在给出所有 n 个水晶的初始状态，问最少需要多少次开关操作才能使所有水晶 变为关闭状态。
 *
 * 神族水晶长这样
 *
 * 输入
 * 一个字符串，包含 N 个字符（1<= N <=1000）。其中第 i 个字符为 1 表示为初始状态为 开，0 表示为初始状态为 关。
 *
 * 输出
 * 一个整数，表示操作开关使所有水晶变为 关闭状态 最少需要的操作次数。 如果不可能关掉所有开关，输出 -1。
 *
 * 输入样例
 * 111111
 * 101010101
 * 11101110111011011110
 *
 * 输出样例
 * 1
 * 2
 * 4
 *
 * Created by zhouyanhui on 2019/11/24.
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

    private static int solution(String line) {
        boolean[] btns = new boolean[line.length()];
        for (int i = 0; i < line.length(); i++) {
            btns[i] = line.charAt(i) == '1';
        }
        int count = 0;
        for (int i = 0; i < btns.length; i++) {
            if(btns[i]){
                count++;
                shutdown(btns, i);
            }
        }
        return count;
    }

    private static void shutdown(boolean[] btns, int idx) {
        int k = 1, i = (idx + 1) * k - 1;
        while (i < btns.length){
            btns[i] = !btns[i];
            k++;
            i = (idx + 1) * k - 1;
        }
    }
}

