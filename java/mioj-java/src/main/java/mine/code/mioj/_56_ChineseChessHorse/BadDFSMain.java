package mine.code.mioj._56_ChineseChessHorse;



/**
 * - 马走日
 * 序号：#56
 * 难度：困难
 * 时间限制：1500ms
 * 内存限制：10M
 * 描述
 * 在中国象棋中，马只能走日字型。现在给出一个由 N*M 个格子组成的中国象棋棋盘( 有(N+1)*(M+1)个交叉点可以落子 )，以及棋盘上的两个坐标点 S,T。请计算出从 S 到 T 使用日字型走法所需的最少步数，如果不能到达，则输出-1。
 *
 * 下图为一个 1x2 的棋盘，起始落子点（蓝色）为 (0, 0)，目标落子点（绿色）为 (1,2) 的示意，此时需要的步数为 1：
 *
 * 56
 *
 * 输入
 * 单组数据。
 *
 * 第 1 行：1 个数，表示 N 的值
 * 第 2 行：1 个数，表示 M 的值
 * 第 2 行：两个数，分别代表 S 点的 x,y 坐标
 * 第 4 行：两个数，分别代表 T 点的 x,y 坐标
 * 输入保证满足 (1<=N<=1000, 1<=M<=1000, 0<=x<=N, 0<=y<=M)
 *
 * 输出
 * 所需的最少步数，不能到达则输出 -1.
 *
 * 输入样例
 * 1
 * 1
 * 0 0
 * 1 1
 *
 * 2
 * 2
 * 0 0
 * 1 2
 *
 * 输出样例
 * -1
 *
 * 1
 *
 * DFS + 回溯： (超时 / java.lang.StackOverflowError)
 * Created by zhouyanhui3 on 19-11-20.
 */

import java.util.*;

public class BadDFSMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine().trim());
        int M = Integer.valueOf(scan.nextLine().trim());
        String[] split = scan.nextLine().trim().split(" ");
        int[] S = new int[]{Integer.valueOf(split[0]), Integer.valueOf(split[1])};
        split = scan.nextLine().trim().split(" ");
        int[] T = new int[]{Integer.valueOf(split[0]), Integer.valueOf(split[1])};
        int answer = solution(S, T, N, M);
        System.out.println(answer);
    }

    private static int solution(int[] s, int[] t, int n, int m) {
        boolean[][] visited = new boolean[n+1][m+1];
        int step = go(s[0], s[1], t[0], t[1], n, m, visited);
        if(step == Integer.MAX_VALUE){
            return -1;
        }
        return step;
    }

    private static int go(int sx, int sy, int tx, int ty, int n, int m, boolean[][] visited) {
        if(sx == tx && sy == ty) {
            return 0;
        }
        visited[sx][sy] = true;
        int min = Integer.MAX_VALUE;
        if(sx + 2 <= n && sy + 1 <= m && !visited[sx + 2][sy + 1]){
            int step = go(sx + 2, sy + 1, tx, ty, n, m, visited);
            min = Math.min(min, step);
        }
        if(sx + 1 <= n && sy + 2 <= m && !visited[sx + 1][sy + 2]){
            int step = go(sx + 1, sy + 2, tx, ty, n, m, visited);
            min = Math.min(min, step);
        }
        if(sx - 1 >= 0 && sy + 2 <= m && !visited[sx - 1][sy + 2]){
            int step = go(sx - 1, sy + 2, tx, ty, n, m, visited);
            min = Math.min(min, step);
        }
        if(sx - 2 >= 0 && sy + 1 <= m && !visited[sx - 2][sy + 1]){
            int step = go(sx - 2, sy + 1, tx, ty, n, m, visited);
            min = Math.min(min, step);
        }
        if(sx - 2 >= 0 && sy - 1 >= 0 && !visited[sx - 2][sy - 1]){
            int step = go(sx - 2, sy - 1, tx, ty, n, m, visited);
            min = Math.min(min, step);
        }
        if(sx - 1 >= 0 && sy - 2 >= 0 && !visited[sx - 1][sy - 2]){
            int step = go(sx - 1, sy - 2, tx, ty, n, m, visited);
            min = Math.min(min, step);
        }
        if(sx + 1 <= n && sy - 2 >= 0 && !visited[sx + 1][sy - 2]){
            int step = go(sx + 1, sy - 2, tx, ty, n, m, visited);
            min = Math.min(min, step);
        }
        if(sx + 2 <= n && sy - 1 >= 0 && !visited[sx + 2][sy - 1]){
            int step = go(sx + 2, sy - 1, tx, ty, n, m, visited);
            min = Math.min(min, step);
        }
        visited[sx][sy] = false;
        if(min == Integer.MAX_VALUE){
            return min;
        }
        return min + 1;
    }

}
