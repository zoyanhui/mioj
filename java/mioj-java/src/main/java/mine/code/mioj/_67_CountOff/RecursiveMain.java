package mine.code.mioj._67_CountOff;

/**
 *  开始报数
 * 序号：#67
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 有 500 个小孩围成一圈，编号从 1 到 500，从第一个开始报数：1，2，3，1，2，3，1，2，3，……每次报到 3 的小孩退出。问第 n 个被淘汰的小孩，在最开始 500 人里是的编号是几？
 *
 * 输入
 * 正整数 N，表示要计算的为第 N 个淘汰的小孩的编号，0 < N <= 500
 *
 * 输出
 * 第 N 个淘汰的小孩的编号
 *
 * 输入样例
 * 1
 * 2
 * 206
 * 311
 *
 * 输出样例
 * 3
 * 6
 * 176
 * 223
 *
 * Created by zhouyanhui on 2019/11/24.
 */
import java.util.*;

//TODO: 理解递归关系
public class RecursiveMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int N = Integer.valueOf(line);
            System.out.println(solution(N));
        }
    }

    private static int solution(int n) {
        return calc(n, 500);
    }

    private static int calc(int n, int m) {
        if(m == 1){
            return m;
        }
        if(n == 1){
            return 3 % m == 0 ? m : 3 % m;
        }
        int res = (3 + calc(n -1, m -1)) % m;
        if(res == 0){
            return m;
        }
        return res;
    }
}

