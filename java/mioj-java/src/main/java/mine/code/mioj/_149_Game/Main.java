package mine.code.mioj._149_Game;

/**
 * - Game
 * 序号：#149
 * 难度：一般
 * 时间限制：2000ms
 * 内存限制：128M
 * 描述
 * Alice 和 Bob 玩起了掷骰子的游戏，为了增加趣味性，他们制定了一套新的判断规则。
 *
 * 两人同时掷 nn 个骰子，每个骰子会等概率掷出 1...61...6 这六种点数中的一种，总点数大的人获胜，总点数一样就继续掷，重复如此直到游戏结束。
 *
 * 为了避免偶然性，每次游戏他们会玩 kk 局，Alice 想知道她赢的局的期望。
 *
 * 输入
 * 输入第一行有一个正整数 TT，代表游戏的次数。 第二行到第 T+1T+1 行每行有两个正整数 n，k 分别代表本次游戏每一局掷骰子的数量和局数。
 *
 * 1 \leq T \leq 100,0001≤T≤100,000
 * 1 \leq n, k \leq 1,000,000,0001≤n,k≤1,000,000,000
 * 输出
 * 输出有 TT 行，每一行一个数代表 AliceAlice 赢得局数的期望，结果保留两位小数。
 *
 * 输入样例
 * 1
 * 1 1
 *
 * 输出样例
 * 0.50
 * Created by zhouyanhui on 2019/11/30.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        int T = Integer.valueOf(scan.nextLine().trim());
        int i = 0;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
            i++;
            if(i >= T){
                break;
            }
        }
    }

    private static String solution(String line) {
        String[] s = line.split(" ", 2);
        int n = Integer.valueOf(s[0]);
        int k = Integer.valueOf(s[1]);
        double win = 0.5 * k;
        return String.format("%.2f", win);
    }
}

