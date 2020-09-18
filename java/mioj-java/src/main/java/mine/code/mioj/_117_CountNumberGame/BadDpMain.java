package mine.code.mioj._117_CountNumberGame;

/**
 * - 数数字游戏
 * 序号：#117
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 小爱和小冰是一对好闺蜜，她们都是世界上最聪明的人工智能之一。某一天，他们俩一起玩数数字游戏，规则如下：
 *
 * 首先小爱和小冰各说一个目标数字num1num1,num2num2；
 * 小爱和小冰轮流报数（小冰报数方法与小爱相同），每次只报一个数，报数者可以选择将这个数报给谁；
 * 小爱先开始报数字，把这个数给自己或小冰都行，小爱和小冰各自得到的所有数之和不能超过自己的目标数字；
 * 最终，谁再也报不出符合条件的数字谁就算输，另一个人就赢（即谁报完数后，两人所得数字之和都达到了各自的目标数字，谁就赢）；
 * 由于两人智商都是非常的高，所以觉得游戏太简单了，于是两人决定每次报的数只能是斐波那契数列中的元素（例如每次取1，2，3，5，8.......) 。
 * 现在两人各说一个目标数字后请你判断谁会赢。如果小爱赢则输出"Xiaoai Win"，反之小冰赢输出"Xiaobing Win"。两人都很聪明，都会使用最优策略（每次报数是最优的）。
 *
 * 规定：斐波那契数列F(1)=1,F(2)=2,F(N)=F(N-1)+F(N-2)F(1)=1,F(2)=2,F(N)=F(N−1)+F(N−2)
 * 输入
 * 多组数据，每组输入两个正整数，用空格隔开，分别表示小爱和小冰的目标数字num1num1,num2num2。
 *
 * 数据范围：num1,num2 &lt;= 10000num1,num2<=10000
 * 输出
 * 输出 "Xiaoai Win" 或 "Xiaobing Win"，分别表示小爱赢或小冰赢。每个结果 1 行。
 *
 * 输入样例
 * 1 4
 * 3 4
 * 4 4
 * 1 5
 * 10000 10000
 *
 * 输出样例
 * Xiaoai Win
 * Xiaoai Win
 * Xiaobing Win
 * Xiaobing Win
 * Xiaobing Win
 *
 *
 * Error: java.lang.OutOfMemoryError: Java heap space. -Xmx10m
 * Created by zhouyanhui on 2019/12/1.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BadDpMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] s = line.split(" ");
            System.out.println(solution(Integer.valueOf(s[0]), Integer.valueOf(s[1])));
        }
    }

    private static String solution(int a, int b) {
        int[][] dp = new int[a+1][b+1]; // java.lang.OutOfMemoryError: Java heap space. -Xmx10m
        dp[0][0] = -1;
        int[] fbs = calcFbs(a, b);
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if(dp[i][j] == 0){
                    continue;
                }
                boolean fin = false;
                for (int k = 0; k < fbs.length; k++) {
                    int ni = i + fbs[k];
                    int nj = j+fbs[k];
                    if(ni > a && nj > b){
                        break;
                    }
                    if(ni <= a) {
                        if (dp[ni][j] == 0) {
                            dp[ni][j] = -dp[i][j];
                        }
                        if (ni == a && j == b) {
                            fin = true;
                            break;
                        }
                    }
                    if(nj <= b) {
                        if (dp[i][nj] == 0) {
                            dp[i][nj] = -dp[i][j];
                        }
                        if (i == a && nj == b) {
                            fin = true;
                            break;
                        }
                    }
                }
                if(fin){
                    break;
                }
            }
        }
        if(dp[a][b] == 1){
            return "Xiaoai Win";
        }
        return "Xiaobing Win";
    }

    private static int[] calcFbs(int a, int b) {
        List<Integer> fbs = new ArrayList<>();
        int fb1 = 1, fb2 = 1;
        fbs.add(fb2);
        int m = Math.max(a, b);
        while (true) {
            int temp = fb1 + fb2;
            fb1 = fb2;
            fb2 = temp;
            if (fb2 > m) {
                break;
            }
            fbs.add(fb2);
        }
        int[] res = new int[fbs.size()];
        for (int i = 0; i < fbs.size(); i++) {
            res[i] = fbs.get(i);
        }
        return res;
    }

    private static int calc(List<Integer> fbs, Integer a, Integer b) {
        if(a == 0 && b == 0){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < fbs.size(); i++) {
            boolean hasNext = false;
            int fb = fbs.get(i);
            if (a > fb) {
                hasNext = true;
                max = Math.max(max, 1 - calc(fbs, a - fb, b));
            }
            if (b > fb) {
                hasNext = true;
                max = Math.max(max, 1 - calc(fbs, a, b - fb));
            }
            if (!hasNext) {
                break;
            }
        }
        return max;
    }
}

