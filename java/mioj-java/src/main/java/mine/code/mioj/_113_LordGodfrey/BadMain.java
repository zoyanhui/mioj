package mine.code.mioj._113_LordGodfrey;

/**
 * - 高弗雷勋爵
 * 序号：#113
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 黑暗女王希尔瓦娜斯将高弗雷复活为被遗忘者的一员。这个时候的高弗雷，已经完全没有生前的样子，看起来阴险又狡诈，言语不再有任何礼节性的修饰，时常将恶毒的语言挂在嘴上，谈及自己的过去，满满的只有怨恨。高弗雷当然不愿意臣服于希尔瓦娜斯，但是为了达成毫无察觉的背叛，他需要证明自己的“忠诚”——前去摧毁联盟第七军团的据点，等待他的奖励不出意外是一台品罗小怪兽料理机。
 *
 * 第七军团的据点有数不清的敌人，高弗雷拿着一把附魔火枪，射出的子弹会在敌人间跳跃，一发子弹就能对所有敌人造成 2 点伤害，如果该子弹导致了任意敌人死亡（即血量小于等于 0），该子弹还会再次对所有敌人造成2点伤害，直到没有新的敌人死亡为止。
 *
 * 那么，高弗雷需要打出几颗子弹才能消灭所有敌人呢？
 *
 * 输入
 * 输入是每个敌人的血量，用空格分开，回车结束。0<敌人的数量<=10000; 0<敌人的血量<=10^9
 *
 * 输出
 * 输出是一个数字，是高弗雷最少需要打出的子弹的个数
 *
 * 输入样例
 * 1 12 3 6 10
 * 14 81 93 97 77 80 84 63 94 60 98 36 42 50 20 39 56 28 24 79
 *
 * 输出样例
 * 2
 * 33
 *
 * 本解法与题意不符：
 *   题意是：一颗子弹导致敌人死亡，不论多少，最多增加一颗奖励子弹。
 *   解法是：一颗子弹导致敌人死亡，一个敌人死亡增加一颗奖励子弹。
 *   
 * Created by zhouyanhui on 2019/12/1.
 */

import java.util.Arrays;
import java.util.Scanner;

public class BadMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int[] ints = splitToInts(line, " ");
            System.out.println(solution(ints));
        }
    }

    private static int solution(int[] ints) {
        if(ints.length == 0){
            return 0;
        }
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        int silves = calc(ints[0]);
        int damange = 2*silves + 2;
        for (int i = 1; i < ints.length; i++) {
            if(ints[i] <= damange){
                damange += 2;
            }else{
                int silvesPlus = calc(ints[i] - damange);
                silves += silvesPlus;
                damange += 2 * silvesPlus + 2;
            }
        }
        return silves;
    }

    private static int calc(int n) {
        if((n  & 0x1) == 1){
            return n/2 + 1;
        }
        return n/2;
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

