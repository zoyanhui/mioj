package mine.code.mioj._139_LogicGateKeeper;

/**
 * - Logic Gatekeeper
 * 序号：#139
 * 难度：非常难
 * 时间限制：5000ms
 * 内存限制：100M
 * 描述
 * boshi是Rayment的好朋友。
 *
 * Rayment最近迷上了一个叫Just Shapes & Beats的音游，于是就推荐给了boshi(网易云上也有这个游戏部分音乐的歌单)。可boshi有点着迷于游戏音乐难以集中精神，有时反应慢了半拍，导致他在第二关就挂了一回。忍无可忍的boshi摘下了耳机，他决定用个更科学的方法来通过这一关。
 *
 * 这首歌的名字就叫做Logic Gatekeeper。如果想的话，你也可以一边听歌一边切这道题目。
 *
 * 游戏的不同关卡攻击方式都不一样，但这关的攻击方式比较简单。形式化地来说，攻击可以被具象化为对一个矩阵的攻击，也就是说如果你待在这个矩阵的范围内，你就会受到1的攻击。
 *
 * 游戏界面可以认为是一个n×m的矩阵，而游戏角色恰好占一个方格的位置。boshi会进行不断地进行预测某个子矩阵的攻击概率升高或降低了一定数值，同时为了评估某一个子矩阵的安全性，他也要知道如果他随机待在子矩阵内的一个位置，受到攻击的期望是多少。当然，初始时整个游戏界面任意一个位置的攻击概率为0。
 *
 * 为了避免小数产生的误差，boshi给出的所有的概率都是在模998244353998244353意义下的值，因此你在输出期望的时候也应该对998244353998244353取模。
 *
 * Rayment听得脑袋都晕了，boshi只好请你来帮他过了这关，不受一点攻击才能拿到S评定。
 *
 * 输入
 * 第一行三个整数n,m,q，含义同题目描述。
 *
 * 接下来q行有两种格式，如下：
 *
 * 1 a b c d k，含义是以(a,b)为左下角,(c,d)为右上角的子矩阵的攻击概率均加上k
 * 2 a b c d，含义是询问以(a,b)为左下角,(c,d)为右上角的子矩阵的攻击期望
 * 数据有梯度，且对于100\%100%的数据保证满足：
 *
 * 1\leq n,m\leq 10^6,1\leq q\leq 10^51≤n,m≤10
 * 6
 *  ,1≤q≤10
 * 5
 *
 * 1\leq a\leq c\leq n,1\leq b\leq d\leq m,0\leq k&lt;9982443531≤a≤c≤n,1≤b≤d≤m,0≤k<998244353
 * 输出
 * 对于每一个2操作，输出一行一个整数，表示相应的答案。
 *
 * 输入样例
 * 4 4 3
 * 1 1 1 3 3 4
 * 1 2 3 4 4 5
 * 2 2 2 3 3
 *
 * 输出样例
 * 499122183
 *
 *
 * Created by zhouyanhui on 2019/12/7.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here

            // System.out.println("answer");
        }
    }
}


