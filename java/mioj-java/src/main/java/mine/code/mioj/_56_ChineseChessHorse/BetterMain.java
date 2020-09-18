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
 * 1000
 * 1000
 * 3 4
 * 678 345
 *
 * 输出样例
 * -1
 *
 * 1
 *
 * BFS
 * Created by zhouyanhui3 on 19-11-20.
 */

import java.util.*;

public class BetterMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine().trim());
        int M = Integer.valueOf(scan.nextLine().trim());
        String[] split = scan.nextLine().trim().split(" ");
        int sx = Integer.valueOf(split[0]), sy = Integer.valueOf(split[1]);
        split = scan.nextLine().trim().split(" ");
        int tx = Integer.valueOf(split[0]), ty = Integer.valueOf(split[1]);
        int answer = solution(new int[]{tx, ty}, new int[]{sx, sy, 0}, N, M);
        System.out.println(answer);
    }

    private static int solution(int[] t, int[] s, int n, int m) {
        if(s[0] == t[0] && s[1] == t[1]) {
            return 0;
        }
        Queue<int[]> walked = new LinkedList<>();
        walked.add(s);
        boolean[][] visited = new boolean[n+1][m+1];
        int[][] directors = new int[][]{{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        while(!walked.isEmpty()){
            int[] c = walked.poll();
            for (int i = 0; i < directors.length; i++) {
                if(tryNext(c, t, n, m, walked, visited, directors[i][0], directors[i][1])){
                    return c[2] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean tryNext(int[] s, final int[] t, int n, int m, Queue<int[]> walked, boolean[][] visited, int deltaX, int deltaY) {
        int sx = s[0], sy = s[1], tx = t[0], ty = t[1];
        int step = s[2];
        sx += deltaX;
        sy += deltaY;
        if (sx >= 0 && sx <= n && sy >= 0 && sy <= m) {
            if(visited[sx][sy]){
                return false;
            }
            if (sx == tx && sy == ty) {
                return true;
            }
            visited[sx][sy] = true;
            walked.add(new int[] {sx, sy, step + 1});
        }
        return false;
    }
}
