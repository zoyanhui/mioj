package mine.code.mioj._104_SharedEdgeTriangle;

/**
 * - 共边三角形
 * 序号：#104
 * 难度：非常难
 * 时间限制：2500ms
 * 内存限制：20M
 * 描述
 * 这一题实在没办法植入广告，直接感谢小米生态链企业品罗及亿联客强力赞助：
 *
 * 已知原点OO坐标为(0,0)(0,0)，给定xx轴正半轴一个点A(x, 0)A(x,0)，再给出第一象限的nn个点(x_1,y_1)(x
 * 1
 * ​
 *  ,y
 * 1
 * ​
 *  ), (x_2,y_2)(x
 * 2
 * ​
 *  ,y
 * 2
 * ​
 *  ), … , (x_n,y_n)(x
 * n
 * ​
 *  ,y
 * n
 * ​
 *  )，这nn个点分别向原点OO和点AA连线，得到nn个三角形，某些三角形间可能存在包含关系，要求两个存在包含关系的三角形只能有OAOA这一条边共线。
 *
 * 求三角形个数最多的包含关系，只需输出此包含关系中三角形的个数。
 *
 * 图示采用品罗中性笔精心绘制如下：
 *
 * triangle
 *
 * 如图答案为 2，\triangle OAB△OAB 包含 \triangle OAC△OAC.
 *
 * 输入
 * 输入数据为空格分隔的多个数：
 *
 * 第 1 个数字为AA点横坐标xx;
 *
 * 第 2 个数字为第一象限点的个数nn;
 *
 * 接下来数据是nn个二元组的横坐标和纵坐标，代表这nn个点的坐标，以x_1 \text{ } y_1 \text{ } x_2 \text{ } y_2 \cdots x_n \text{ } y_nx
 * 1
 * ​
 *   y
 * 1
 * ​
 *   x
 * 2
 * ​
 *   y
 * 2
 * ​
 *  ⋯x
 * n
 * ​
 *   y
 * n
 * ​
 *  的顺序给出。
 *
 * 数据范围：0&lt;x&lt;100000000, 0&lt;n&lt;10009, 0&lt;x_i&lt;100000000, 0&lt;y_i&lt;1000000000<x<100000000,0<n<10009,0<x
 * i
 * ​
 *  <100000000,0<y
 * i
 * ​
 *  <100000000，保证无重复的点。
 *
 * 输出
 * 三角形个数最多的包含关系中的三角形个数。
 *
 * 输入样例
 * 5 5 1 1 2 2 3 3 4 4 5 5
 *
 * 输出样例
 * 1
 *
 *
 * Created by zhouyanhui on 2019/11/30.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int[] ints = splitToInts(line, " ");
            System.out.println(solution(ints));
        }
    }

    static class Point{
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
        Point leftNext;
        Point rightNext;
    }

    static class Slop{
        Slop(int p, double rate){
            this.p = p;
            this.rate = rate;
        }
        double rate;
        int p;
    }

    private static int solution(int[] ints) {
        if(ints.length < 2){
            return 0;
        }
        int n = ints[1];
        if(2 * n + 2 != ints.length){
            return 0;
        }
        Point zero = new Point(0 ,0);
        Point a = new Point(ints[0], 0);
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            Point p = new Point(ints[2 + i*2], ints[2+i*2+1]);
            points[i] = p;
        }
        Slop[] leftSlops = calcSlopRate(points, zero);
        Slop[] rightSlops = calcSlopRate(points, a);
        Arrays.sort(leftSlops, new Comparator<Slop>() {
            @Override
            public int compare(Slop o1, Slop o2) {
                return Double.compare(o1.rate, o2.rate);
            }
        });
        for (int i = 1; i < leftSlops.length; i++) {
            if(Double.compare(leftSlops[i].rate, leftSlops[i-1].rate) != 0){
                points[leftSlops[i].p].leftNext  = points[leftSlops[i-1].p];
            }
        }
        Arrays.sort(rightSlops, new Comparator<Slop>() {
            @Override
            public int compare(Slop o1, Slop o2) {
                return Double.compare(o2.rate, o1.rate);
            }
        });
        for (int i = 1; i < rightSlops.length; i++) {
            if(Double.compare(leftSlops[i].rate, rightSlops[i-1].rate) != 0){
                points[rightSlops[i].p].leftNext  = points[rightSlops[i-1].p];
            }
        }
        for (int i = 0; i < points.length; i++) {

        }
        return longestCommonPointList(leftSlops, rightSlops);
    }

    private static int longestCommonPointList(Slop[] leftSlops, Slop[] rightSlops) {
        int[][] dp = new int[leftSlops.length + 1][rightSlops.length + 1];
        for (int i = 0; i < leftSlops.length; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        for (int i = 0; i < leftSlops.length; i++) {
            for (int j = 0; j < rightSlops.length; j++) {
                if(leftSlops[i].p == rightSlops[j].p){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[leftSlops.length][rightSlops.length];
    }

    private static Slop[] calcSlopRate(Point[] points, Point base) {
        Slop[] slops = new Slop[points.length];
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            double rate = (double)(p.y - base.y) / (p.x - base.x);
            slops[i] = new Slop(i, rate);
        }
        return slops;
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

