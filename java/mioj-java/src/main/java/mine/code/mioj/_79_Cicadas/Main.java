package mine.code.mioj._79_Cicadas;

/**
 * - 知了的鸣叫
 * 序号：#79
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 路边有一排N棵树，每棵树上正好有一只知了，刚开始所有的知了都在睡觉，从早上8点开始，第一棵树上的知了被你吵醒开始鸣叫，一秒后第二棵树上的知了听到了同类的声音被叫醒，也开始鸣叫，再过一秒后第三棵树上的知了听到了第二棵树上知了的声音被叫醒，也开始鸣叫⋯⋯ 每一棵树上的声音传到相邻树上的时间为1秒，且只会传到相邻的树上（其他树距离太远，声音传不过去） 每只知了在鸣叫8秒后会休息8秒，然后继续鸣叫8秒休息8秒⋯⋯ 现在告诉你树的数量N，请问在第k秒内，第m棵树上的知了是否在鸣叫，是输出1,否输出0 （第一支知了开始鸣叫的时刻为第一秒开始）
 *
 * 输入
 * 输入一行数据包含N，k，m，三个数中间用','隔开,1<=N<=10000,1<=k<=40000,1<=m<=N 例如10,2,2
 *
 * 输出
 * 一个数表示第k秒内，第m棵树上的知了是否在鸣叫
 *
 * 输入样例
 * 10,2,2
 * 10,1,2
 * 10,2,3
 *
 * 输出样例
 * 1
 * 0
 * 0
 *
 * Created by zhouyanhui on 2019/11/26.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] split = line.split(",", 3);
            int N = Integer.valueOf(split[0]);
            int k = Integer.valueOf(split[1]);
            int m = Integer.valueOf(split[2]);
            System.out.println(solution(N, k, m));
        }
    }

    private static int solution(int n, int k, int m) {
        if(m > k){
            return 0;
        }
        if((((k - m) / 8) & 0x1) == 0){
            return 1;
        }
        return 0;
    }
}

