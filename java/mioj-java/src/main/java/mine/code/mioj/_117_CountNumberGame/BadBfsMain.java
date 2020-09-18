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
 * BFS
 * java.lang.OutOfMemoryError: GC overhead limit exceeded。 -Xmx=10m
 * Created by zhouyanhui on 2019/12/1.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BadBfsMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] s = line.split(" ");
            System.out.println(solution(Integer.valueOf(s[0]), Integer.valueOf(s[1])));
        }
    }

    static class Node{
        int x;
        int y;
        int v;

        public Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

        @Override
        public int hashCode() {
            return x*13+y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Node) {
                Node o = (Node) obj;
                return x == o.x && y == o.y;
            }
            return false;
        }
    }

    private static String solution(int a, int b) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> visiting = new LinkedList<>();
        Node node = new Node(0, 0, -1);
        visiting.add(node);
        visited.add(node);
        int[] fbs = calcFbs(a, b);
        int win = 0;
        while(!visiting.isEmpty()){
            Node cur = visiting.poll();
            boolean fin = false;
            for (int i = 0; i < fbs.length; i++) {
                int nx = cur.x + fbs[i], ny = cur.y + fbs[i];
                if(nx > a && ny > a){
                    break;
                }
                if(nx <= a) {
                    Node next = new Node(nx, cur.y, -cur.v);
                    if (!visited.contains(next)) {
                        visiting.add(next);
                        visited.add(next);
                    }
                }
                if(nx == a && cur.y == b){
                    fin = true;
                    win = -cur.v;
                    break;
                }
                if(ny <= b){
                    Node next = new Node(cur.x, ny, -cur.v);
                    if (!visited.contains(next)) {
                        visiting.add(next);
                        visited.add(next);
                    }
                }
                if(cur.x == a && ny == b){
                    fin = true;
                    win = -cur.v;
                    break;
                }
            }
            if(fin){
                break;
            }
        }

        if(win == 1){
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

}

