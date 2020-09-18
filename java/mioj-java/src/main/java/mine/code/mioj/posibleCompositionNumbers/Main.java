package mine.code.mioj.posibleCompositionNumbers;

/**
 * - 找出可能的合的组合
 * 序号：#12
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一组不重复的正整数，从这组数中找出所有可能的组合使其加合等于一个目标正整数 M，如：
 *
 * 一组数为 1, 2, 3，目标数为 4，那么可能的加合组合为： 1, 1, 1, 1 1, 1, 2 1, 2, 1 1, 3 2, 1, 1 2, 2 3, 1 注意相同的组合数字顺序不同也算一种，所以这个例子的结果是 7 种。
 *
 * 输入
 * 一组连续不重复的 N 个正整数（, 隔开，0<N<100）以及目标正整数（与数组之间用空格隔开）
 *
 * 输出
 * 所有可能的加合等于目标正整数 M 的组合种数
 *
 * 输入样例
 * 1,2,3 4
 *
 * 输出样例
 * 7
 *
 * Created by zhouyanhui3 on 19-10-31.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] s = line.split(" ", 2);
            if(s.length != 2){
                System.out.println("wrong input");
                continue;
            }
            String[] split = s[0].split(",");
            long M = Long.valueOf(s[1]);
            int N = split.length;
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                int n = Integer.valueOf(split[i]);
                nums[i] = n;
            }
            int totalComp = calcComposition(nums, M);
            System.out.println(totalComp);
        }
    }

    private static int calcComposition(int[] nums, long m) {
        if(m == 0){
            return 1;
        }
        if(m < 0){
            return 0;
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if(m >= nums[i]) {
                total += calcComposition(nums, m - nums[i]);
            }
        }
        return total;
    }
}
