package mine.code.mioj._35_CandySharing;

/**
 * - 分糖果
 * 序号：#35
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 将 M 个同样的糖果放在 N 个同样的篮子里，允许有的篮子空着不放，共有多少种不同的分法？ 比如，把 7 个糖果放在 3 个篮子里，共有 8 种分法（每个数表示篮子中放的糖果数，数的个数为篮子数）： 1 1 5 1 2 4 1 3 3 2 2 3 2 5 0 3 4 0 6 1 0 7 0 0
 *
 * 注意：相同的分布，顺序不同也只算作一种分法，如 7 0 0、0 7 0 和 0 0 7 只算作一种。
 *
 * 输入
 * 输入包含二个正整数 M 和 N，以(,)分开，M 表示有几个同样的糖果，N 表示有几个同样的篮子 M与N范围：1 <= M，N <= 100。
 *
 * 输出
 * 输出一个正整数 K，表示有多少种分法。
 *
 * 输入样例
 * 7,3
 *
 * 输出样例
 * 8
 *
 * 超时
 * Created by zhouyanhui3 on 19-11-12.
 */

import java.util.Scanner;

public class BadMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int answer = solution(line);
            System.out.println(answer);
        }
    }

    private static int solution(String line) {
        String[] split = line.split(",", 2);
        int M = Integer.valueOf(split[0]);
        int N = Integer.valueOf(split[1]);
        return calc(M, N, 0);

    }

    private static int calc(int m, int n, int min) {
        if(m < min){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int total = 0;
        for (int i = min; i <= (m+1)/2; i++) {
            total += calc(m - i, n -1, i);
        }
        return total;
    }
}

