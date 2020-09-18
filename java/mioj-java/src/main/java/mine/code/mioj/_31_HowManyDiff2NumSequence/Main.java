package mine.code.mioj._31_HowManyDiff2NumSequence;

/**
 * - 有多少个公差为 2 的等差数列
 * 序号：#31
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个正整数N（2<= N <=10000000），统计有多少公差为2的正整数等差数列，使得数列的和为N。
 *
 * 举例： 正整数 15，可以写为 15 和 3,5,7 两个等差数列。 其中 15 自身就是一个等差数列，3+5+7=15 也是一个符合条件的等差数列，所以输出为 2，表示有两个符合条件的等差数列。
 *
 * 请注意时间复杂度限制
 * 输入
 * 一个正整数，表示等差数列中所有数的和，范围为 [2, 10000000]
 *
 * 输出
 * 一个正整数，表示可以找到多少符合条件的正整数等差数列。 (由于一个数字也可以算做等差数列，所以输出至少为1)
 *
 * 输入样例
 * 15
 * 30
 * 50
 *
 * 输出样例
 * 2
 * 4
 * 3
 * Created by zhouyanhui3 on 19-11-12.
 */
import java.util.*;

public class Main {
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
        int N = Integer.valueOf(line);
        int count = 0;
        for (int n = 1; n <= Math.sqrt(N) ; n++) {
            if(N % n == 0 && N / n > n - 1){
                count++;
            }
        }
        return count;
    }
}

