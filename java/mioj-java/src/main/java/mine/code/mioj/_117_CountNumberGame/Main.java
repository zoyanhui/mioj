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
 * 首先小爱和小冰各说一个目标数字num1,num2；
 * 小爱和小冰轮流报数（小冰报数方法与小爱相同），每次只报一个数，报数者可以选择将这个数报给谁；
 * 小爱先开始报数字，把这个数给自己或小冰都行，小爱和小冰各自得到的所有数之和不能超过自己的目标数字；
 * 最终，谁再也报不出符合条件的数字谁就算输，另一个人就赢（即谁报完数后，两人所得数字之和都达到了各自的目标数字，谁就赢）；
 * 由于两人智商都是非常的高，所以觉得游戏太简单了，于是两人决定每次报的数只能是斐波那契数列中的元素（例如每次取1，2，3，5，8.......) 。
 * 现在两人各说一个目标数字后请你判断谁会赢。如果小爱赢则输出"Xiaoai Win"，反之小冰赢输出"Xiaobing Win"。两人都很聪明，都会使用最优策略（每次报数是最优的）。
 *
 * 规定：斐波那契数列F(1)=1,F(2)=2,F(N)=F(N-1)+F(N-2)F(1)=1,F(2)=2,F(N)=F(N−1)+F(N−2)
 * 输入
 * 多组数据，每组输入两个正整数，用空格隔开，分别表示小爱和小冰的目标数字num1,num2。
 *
 * 数据范围：num1,num2<=10000
 * 输出
 * 输出 "Xiaoai Win" 或 "Xiaobing Win"，分别表示小爱赢或小冰赢。每个结果 1 行。
 *
 * 输入样例
 * 1 4
 * 3 4
 * 4 4
 * 1 5
 * 5 7
 * 9 3
 * 10000 10000
 * 9999 10000
 *
 * 输出样例
 * Xiaoai Win
 * Xiaoai Win
 * Xiaobing Win
 * Xiaobing Win
 * Xiaoai Win
 * Xiaoai Win
 * Xiaobing Win
 * Xiaoai Win
 *
 *
 * 解法：博弈论，SG函数
 * Created by zhouyanhui on 2019/12/1.
 */

import java.util.*;

public class Main {
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
        int m = Math.max(a, b);
        int[] fbs = calcFbs(m);
        int[] dps = new int[m + 1]; // sg 函数
        int[] hash = new int[m+1];
        for (int i = 1; i <= m; i++) {
            Arrays.fill(hash, 0);
            for (int j = 0; j < fbs.length && fbs[j] <= i; j++) {
                hash[dps[i-fbs[j]]] = 1;
            }
            for (int j = 0; j <=m; j++) {
                if(hash[j] == 0){
                    dps[i] = j;
                    break;
                }
            }
        }
        boolean win = (dps[a] ^ dps[b]) != 0;
        if (win) {
            return "Xiaoai Win";
        }
        return "Xiaobing Win";
    }

    private static int[] calcFbs(int m) {
        List<Integer> fbs = new ArrayList<>();
        int fb1 = 1, fb2 = 1;
        fbs.add(fb2);
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

}

