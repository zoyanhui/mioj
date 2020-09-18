package mine.code.mioj._27_StoneCollect;

/**
 * - 石头收藏家
 * 序号：#27
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 石头收藏家小明在徒步登山的时候发现了一堆美丽的石头。这些石头价值不菲，但是都很重，小明自身的力气有限，一次只能拿他拿得动的一部分。每块石头的重量不同，价值也不同。问小明在力所能及的情况下能拿走价值多少的石头。
 *
 * 说明：小明只能搬运一次。
 *
 * 例如：小明只能拿得动 10 kg，每块石头的重量分别为2kg，3kg，5kg，7kg，对应的价值分别为 1万，5万，2万，4万。小明能拿的是 3kg 以及 7kg 的石头，价值 9 万。
 *
 * 输入
 * 单组输入，每组输入分 3 行：
 *
 * 第 1 行是一个整数，表示小明一次能搬运的最大重量。
 * 第 2 行是一组数，表示每块石头的重量。
 * 第 3 行是一组数，表示每块石头的对应的价值。
 * 石头总数不大于 60.
 *
 * 输出
 * 一个整数，表示小明这次能带回去的石头的总价。
 *
 * 输入样例
 * 10
 * 2 3 5 7
 * 1 5 2 4
 *
 * 输出样例
 * 9
 * Created by zhouyanhui on 2019/11/9.
 */
import java.util.*;

public class RecursiveMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        int i = 0;
        String[] inputs = new String[3];
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            inputs[i++] = line;
            if(i == 3){
                i = 0;
                int answer = solution(inputs);
                System.out.println(answer);
            }
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

    private static int solution(String[] inputs) {
        int maxWeight = Integer.valueOf(inputs[0]);
        int[] weights = splitToInts(inputs[1], " ");
        int[] values = splitToInts(inputs[2], " ");
        return maxValue(weights, values, 0, maxWeight);
    }

    private static int maxValue(int[] weights, int[] values, int idx, int rWeight) {
        if(idx == weights.length){
            return 0;
        }
        int v1 = 0;
        if(rWeight >= weights[idx]) {
            v1 = values[idx] + maxValue(weights, values, idx + 1, rWeight - weights[idx]);
        }
        int v2 = maxValue(weights, values, idx + 1, rWeight);
        return v1 > v2 ? v1 : v2;
    }
}

