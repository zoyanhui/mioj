package mine.code.mioj._47_CoinRace;

/**
 * - 硬币比赛
 * 序号：#47
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 有 n 个不同价值的硬币排成一条线。有 A 与 B 两个玩家，指定由 A 开始轮流（A 先手，然后 B，然后再 A..）从左边依次拿走 1 或 2 个硬币（不能不拿，也不能拿其他个数），直到没有硬币为止。最后计算 A 与 B 分别拿到的硬币总价值，价值高的人获胜。
 *
 * 请依据硬币的排列情况来判定，先手的玩家 A 能否找到必胜策略？
 *
 * 输入
 * 使用逗号(,)分隔的一个正整数数组，表示这排硬币的排列情况与对应价值
 *
 * 输出
 * true 或 false（字符类型），表示玩家 A 能否找到必胜策略
 *
 * 输入样例
 * 1,2,2
 * 1,2,4
 * 12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,3000,30000
 * 12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,12,3,4,5,45,2,3,4,5,6,7,23,4,5,6,7,73,3,54,5,6,7,78,83,4,54,5,6,7,878,93,3,344,5,6,3,3000,3000
 *
 * 输出样例
 * true
 * false
 * true
 * false
 *
 * Created by zhouyanhui3 on 19-11-19.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            boolean answer = solution(line);
            System.out.println(answer);
        }
    }

    private static boolean solution(String line) {
        int[] ints = splitToInts(line, ",");
        int len = ints.length;
        if(len <= 2){
            return true;
        }
        int[][] dp = new int[len + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = -ints[len-1];
        dp[1][1] = ints[len-1];
        for (int i = 1; i < ints.length; i++) {
            int idx = ints.length - 1 - i;
            dp[i+1][0] = Math.min(dp[i][1] - ints[idx], dp[i-1][1] - ints[idx] - ints[idx + 1]);
            dp[i+1][1] = Math.max(dp[i][0] + ints[idx], dp[i-1][0] + ints[idx] + ints[idx + 1]);
        }
        return dp[ints.length][1] > 0;
    }


    private static int[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        int[] ret = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = Integer.valueOf(split[i]);
        }
        return ret;
    }
}

