package mine.code.mioj._122_MMD;

/**
 * - MMD
 * 序号：#122
 * 难度：非常难
 * 时间限制：7000ms
 * 内存限制：128M
 * 描述
 * Miku Miku Dance，简称 MMD， 是一款 3D 拟真舞蹈动画制作工具。
 *
 * Nishikino Curtis 现在接到了一项任务，要制作一段舞蹈。
 *
 * 舞蹈由若干条线段组成，每条线段会有一个优美度 v_iv
 * i
 * ​
 *  。Nishikino Curtis 会以某种顺序遍历所有的线段。注意，只有走完整条线段后，她才会走下一条线段，并且不会再走已经完整走过的线段。每走完一条线段，就能获得该线段对应的优美度。
 *
 * 如果 Nishikino 走过的线段 l_il
 * ​
 *   有交，且 v_i &gt; v_jv
 *  ，且 Nishikino 先走过了 l_il
 *  ，紧接着又走过了 l_jl
 * ​
 *  ，那么就会获得 (v_i + v_j) \times \lfloor \frac{i + j}{2} \rfloor(v
 *  ⌋ 的额外优美度。
 *
 * 请你决定 Nishikino 的遍历顺序，最大化优美度之和，包括固定的优美度，和额外的优美度。
 *
 * 数据范围: n \le 300, v_i \le 1000n≤300,v
 * i
 * ​
 *  ≤1000，所有坐标的绝对值 \le 10 ^ 6≤10
 * 6
 *  。
 *
 * 输入
 * 输入分为两部分：
 *
 * 第 1 部分为一个整数 n，表示线段的数量；
 *
 * 第 2 部分为 n 组数，每组数由 5 个整数构成，这 5 个整数依次为线段 l_il * ​
 *   的两个端点 P_i, Q_iP  *
 *   的坐标（有序数对）x_{P_i}, y_{P_i}, x_{Q_i}, y_{Q_i}x
 * 输出
 * 输出一个整数，代表最大的优美度之和。
 *
 * 输入样例
 * 2 0 0 2 2 1 0 2 2 0 2
 *
 * 输出样例
 * 6
 *
 *
 * Created by zhouyanhui3 on 19-12-4.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int[] ints = splitToInts(line, " ");
            if(ints == null){
                System.out.println("wrong input");
                continue;
            }
            int N = ints[0];
            Line[] lines = new Line[N];
            for (int i = 0; i < N; i++) {
                Line l = new Line(ints[5 * i + 1], ints[5 * i + 2], ints[5 * i + 3], ints[5 * i + 4], ints[5 * i + 5]);
                lines[i] = l;
            }
            int[][] matrix = buildMatrix(N, lines);

        }
    }

    private static int[][] buildMatrix(int N, Line[] lines) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < lines.length; i++) {
            Line l1 = lines[i];
            matrix[i][i] = l1.val;
            for (int j = i+1; j < lines.length; j++) {
                Line l2 = lines[j];
                if(cross(l1, l2)){
                    matrix[i][j] = (matrix[j][i] = (i+j+2)/2 * (l1.val + l2.val));
                }
            }
        }
        return matrix;
    }

    private static boolean cross(Line l1, Line l2) {
        int sina = (l2.xp - l1.xp) * (l2.yq-l1.yp) - (l2.yp - l1.yp) * (l2.xq - l1.xp);
        int sinb = (l2.xp - l1.xq) * (l2.yq-l1.yq) - (l2.yp - l1.yq) * (l2.xq - l1.xq);
        if(sina * sinb > 0){
            return false;
        }
        sina = (l1.xp - l2.xp) * (l1.yq-l2.yp) - (l1.yp - l2.yp) * (l1.xq - l2.xp);
        sinb = (l1.xp - l2.xq) * (l1.yq-l2.yq) - (l1.yp - l2.yq) * (l1.xq - l2.xq);
        if(sina * sinb > 0){
            return false;
        }
        return true;
    }

    static class Line {
        Line(int xp, int yp, int xq, int yq, int val){
            this.xp = xp; this.yp = yp; this.xq = xq; this.yq = yq;
            this.val = val;
        }
        int xp; int yp;
        int xq; int yq;
        int val;
    }

    private static int[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        int[] ret = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = Integer.valueOf(split[i]);
        }
        if(ret[0] * 5 + 1 != ret.length){
            return null;
        }
        return ret;
    }
}
