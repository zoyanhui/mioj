package mine.code.mioj._127_AllRoadsLeadToRome;

/**
 * - 殊途同归
 * 序号：#127
 * 难度：有挑战
 * 时间限制：2500ms
 * 内存限制：100M
 * 描述
 * 在小米之城，有 nn 个小镇（从 1 开始编号），这些小镇通过 mm 条双向火车铁轨相连，当然某些小镇之间也有公路相连。为了保证每两个小镇之间的人可以方便地互访，市长米小兔就在那些没有铁轨连接的小镇间建造了公路。在两个直接通过公路或铁路相连的小镇之间移动，需要花费 1 小时。火车只能走铁路，汽车只能走公路。
 *
 * 现在有一辆火车和一辆汽车同时从小镇 1 出发，各自前往小镇 n。但是，他们中途不能同时停在同一个小镇（但是可以同时停在小镇 n）。
 *
 * 现在请你来为火车和汽车分别设计一条线路，使火车和汽车尽可能快地到达小镇 nn（即要求他们中最后到达小镇 nn 的时间最短）。
 *
 * 所有的公路或铁路可以被多次使用，求当火车、汽车中各自到达小镇时间最短时，总用时最小的一个。(火车和汽车可以同时到达小镇 nn，也可以先后到达。)
 *
 * 输入
 * 单组测试数据。
 *
 * 首先有 2 个整数 nn 和 mm (2 \le n \le 400, 0 \le m \le n \cdot \frac{n-1}{2}2≤n≤400,0≤m≤n⋅
 * 2
 * n−1
 * ​
 *  ) ，分别表示小镇的数目和铁轨的数目；
 *
 * 接下来的 mm 对数字，每对由两个整数 uu 和 vv 构成，表示小镇 uu 和小镇 vv 之间有一条铁路。(1 \le u,v \le n, u \neq v1≤u,v≤n,u
 * ̸
 * ​
 *  =v)。
 *
 * 输入中保证两个小镇之间最多有一条铁路直接相连。
 *
 * 输出
 * 输出一个整数，表示答案，如果没有合法的路线规划，输出 -1.
 *
 * 输入样例
 * 4 2 1 3 3 4
 *
 * 输出样例
 * 2
 *
 *
 * Created by zhouyanhui on 2019/12/6.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] s = line.split(" ");
            int n = Integer.valueOf(s[0]);
            int m = Integer.valueOf(s[1]);
            if(m == 0 || m == n * (n -1) / 2){
                System.out.println(-1);
                continue;
            }
            boolean[][] roads = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                int city1 = Integer.valueOf(s[2*i + 2]);
                int city2 = Integer.valueOf(s[2*i + 3]);
                roads[city1-1][city2-1] = true;
                roads[city2-1][city1-1] = true;
            }
            int[] steps = new int[n];
            for (int i = 0; i < n; i++) {
                steps[i] = n;
            }
            steps[0] = 0;
            if(roads[0][n-1]){
                bfs(roads, false, steps);
            }else{
                bfs(roads, true, steps);
            }
            if(steps[n-1] == n){
                System.out.println(-1);
            }else {
                System.out.println(steps[n - 1]);
            }
        }
    }

    private static void bfs(boolean[][] roads, boolean flag, int[] steps) {
        boolean[] visited = new boolean[roads.length];
        Queue<Integer> walking = new LinkedList<>();
        walking.add(0);
        visited[0] = true;
        while(!walking.isEmpty()){
            Integer curIdx = walking.poll();
            for (int i = 0; i < roads.length; i++) {
                if(i == curIdx){
                    continue;
                }
                if(!visited[i] && roads[curIdx][i] == flag){
                    steps[i] = Math.min(steps[i], steps[curIdx] + 1);
                    walking.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

