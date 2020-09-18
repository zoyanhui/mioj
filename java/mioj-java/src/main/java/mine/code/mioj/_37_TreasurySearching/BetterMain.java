package mine.code.mioj._37_TreasurySearching;

/**
 * - 寻找宝藏
 * 序号：#37
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 很久以前，有一个很古老而且很富有的民族，但是有一天，他们惨遭外敌入侵，族人都惨遭杀害无一幸免。族长在最后时刻，为了防止财宝落入贼人之手，把财宝藏在了一个秘密的地方，并设置了一些机关，必须解开所有机关才能够获得宝藏。 假设族长一共设置 n 道机关，分别用0 ~ n-1表示。这些机关中有的可以直接解开，有的机关必须要先解开另一个或另一些机关之后才能解开该机关。 有一天你机缘巧合来到了这个地方，请问你能否顺利解开所有机关拿到宝藏？
 *
 * 举例： 假设有两个机关：0 和 1。 如果要求解开1之前先解开 0，而对 0 没有先决条件要求，则可以先解开 0，再解开 1，从而获得宝藏； 如果要求解开1之前先解开 0，同时解开 0 之前先解开 1，则由于 0 与 1 互为先决条件，所以无法解开 0 与 1，因此无法获得宝藏。
 *
 * 输入
 * 单组输入，每组包含 kk 行（0 \lt k \lt 10000<k<1000)：
 *
 * 第 1 行：一个正整数 nn，表示一共设置了多少机关，0 \lt n \lt 1000<n<100;
 * 第 2~kk 行：每行由两个整数构成，分别为 aa 和 bb，表示要解开 aa 机关必须先解开 bb 机关，aa 与 bb 的范围：0 \le a,b \le n-10≤a,b≤n−1
 * 输出
 * 输出字符串类型的 "true" 或者 "false"，均为小写，表示是否能够解开所有机关拿到宝藏。
 *
 * 输入样例
 * 2
 * 0 1
 * 1 0
 *
 * 6
 * 1 0
 * 2 0
 * 2 1
 * 4 1
 * 3 1
 * 3 2
 * 5 2
 * 3 5
 *
 * 6
 * 1 0
 * 2 0
 * 2 1
 * 4 1
 * 3 1
 * 2 3
 * 5 2
 * 3 5
 *
 * 10
 * 0 1
 * 3 4
 * 4 5
 * 5 3
 * 6 7
 * 8 9
 *
 * 输出样例
 * false
 *
 * true
 *
 * false
 *
 * false
 *
 * 解法； DFS+回溯，判断是否有环
 * Created by zhouyanhui on 2019/11/16.
 */

import java.util.*;

public class BetterMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine().trim());
        boolean[][] edges = new boolean[n][n];
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if(line.isEmpty()){
                break;
            }
            // please write your code here
            String[] s = line.split(" ", 2);
            edges[Integer.valueOf(s[1])][Integer.valueOf(s[0])] = true;
        }
        boolean answer = solution(n, edges);
        System.out.println(answer);
    }

    private static boolean solution(int n, boolean[][] edges) {
        boolean[] used = new boolean[n];
        boolean[] inpath = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (dfsCheckCircle(i, used, edges, inpath)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfsCheckCircle(int n, boolean[] used, boolean[][] edges, boolean[] inpath) {
        used[n] = true;
        inpath[n] = true;
        for (int i = 0; i < edges[n].length; i++) {
            if (!edges[n][i]) {
                continue;
            }
            if (inpath[i]) {
                return true;
            }
            if (dfsCheckCircle(i, used, edges, inpath)) {
                return true;
            }
        }
        inpath[n] = false;
        return false;
    }
}

