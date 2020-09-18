package mine.code.mioj._10_ClimbingStairs;


/**
 * - 爬楼梯
 * 序号：#10
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 在你面前有一个n阶的楼梯，你一步只能上1阶或2阶。 请问计算出你可以采用多少种不同的方式爬完这个楼梯。
 *
 * 输入
 * 一个正整数，表示这个楼梯一共有多少阶
 *
 * 输出
 * 一个正整数，表示有多少种不同的方式爬完这个楼梯
 *
 * 输入样例
 * 5
 * 10
 *
 * 输出样例
 * 8
 * 89
 *
 * Created by zhouyanhui3 on 19-10-30.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int stairs = Integer.valueOf(line);
            if(stairs == 1){
                System.out.println(1);
                continue;
            }
            if(stairs <= 0){
                System.out.println("wrong input");
                continue;
            }
            long n0 = 1;
            long n1 = 1;
            for (int i = 2; i <= stairs; i++) {
                long n2 = n0 + n1;
                n0 = n1;
                n1 = n2;
            }
            System.out.println(n1);

            // System.out.println("answer");
        }
    }
}
