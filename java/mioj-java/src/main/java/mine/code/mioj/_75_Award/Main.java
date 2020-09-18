package mine.code.mioj._75_Award;

/**
 * - 发奖励
 * 序号：#75
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 小明老师准备给一些得到小红花的小朋友发糖果做为奖励。 假设有n个小朋友，每个小朋友拥有的小红花为m(n)个，他让这n个小朋友站成一排。要求： 1.每个小朋友至少发一个糖果 2.如果一个小朋友比相邻的小朋友小红花多，则发他的糖果也必须比相邻的多 问小明最少要发多少个糖果？
 *
 * 输入
 * 每位小朋友的小红花数量，使用逗号(,)分隔
 *
 * 输出
 * 最少需要发出的糖果
 *
 * 输入样例
 * 96
 * 19,9,35,74,22
 * 19,9,35,74,22,21
 * 19,9,35,74,22,23
 * 19,9,35,74,22,21,20
 * 19,9,35,74,22,21,20,19
 * 94,84,86,46,30,97,87,20,1,53,82,25,25,55,79,77,20,25,15,35,52,71,1,76,22
 *
 * 输出样例
 * 1
 * 9
 * 11
 * 11
 * 15
 * 20
 * 50
 *
 *
 * Created by zhouyanhui3 on 19-11-25.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int[] ints = splitToInts(line, ",");
            System.out.println(solution(ints));
        }
    }

    private static int solution(int[] ints) {
        if(ints.length == 0){
            return 0;
        }
        int peek = 0, valley = 0;
        Boolean desc = null;
        int total = 1, lastPeek = 1;
        for (int i = 1; i < ints.length; i++) {
            if(ints[i] > ints[i-1]){
                if(desc != null && desc){
                    valley = i - 1;
                    int n = valley - peek + 1;
                    if(n <= lastPeek) {
                        total += (1 + n) * n / 2 - n;
                    }else{
                        total += (1 + n) * n / 2 - lastPeek;
                    }
                }
                desc = false;
                peek = i;
            }else if(ints[i] < ints[i-1]) {
                if(desc != null && !desc){
                    peek = i - 1;
                    int n = peek - valley + 1;
                    lastPeek = n;
                    total += (1 + n) * n /2 - 1;
                }
                desc = true;
                valley = i;
            }else{
                if(desc != null){
                    if(desc){
                        valley = i - 1;
                        int n = valley - peek + 1;
                        if(n <= lastPeek) {
                            total += (1 + n) * n / 2 - n;
                        }else{
                            total += (1 + n) * n / 2 - lastPeek;
                        }
                    }else {
                        peek = i - 1;
                        int n = peek - valley + 1;
                        total += (1 + n) * n / 2 - 1;
                    }
                }
                total += 1;
                lastPeek = 1;
                desc = null;
                valley = i;
                peek = i;
            }
        }
        if(desc != null) {
            if (desc) {
                int n = ints.length - 1 - peek + 1;
                if (n <= lastPeek) {
                    total += (n + 1) * n / 2 - n;
                } else {
                    total += (n + 1) * n / 2 - lastPeek;
                }
            } else {
                int n = ints.length - 1 - valley + 1;
                total += (n + 1) * n / 2 - 1;
            }
        }
        return total;
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

