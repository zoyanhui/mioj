package mine.code.mioj._114_XiaoaiPlayBadminton;

/**
 * - 打羽毛球的小爱同学
 * 序号：#114
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：100M
 * 描述
 * 小爱同学加入了小米羽毛球俱乐部。羽毛球俱乐部里有nn个同学, 其中aa个同学没有羽毛球也没有球拍，bb个同学只有一个羽毛球拍，cc个同学只有一个羽毛球，dd个同学既有一个羽毛球又有一个羽毛球拍，a+b+c+d=na+b+c+d=n.
 *
 * 这周，俱乐部组织同学们一起玩羽毛球，每个同学可以选择参加或者不参加，获得最终胜利的同学可获得 Yeelight 智能护眼台灯一个。羽毛球场有且仅有 1 个，为了打羽毛球，参加活动的同学一共至少要有 1 个羽毛球和 2 个球拍，如果没有足够的球或球拍，这个活动会被取消。
 *
 * 易知，同学参加活动的可能情况有2^n2
 * n
 *  种（每个人可以选择参加或不参加）。现在，小爱想知道2^n2
 * n
 *  种可能里，有多少种情况下活动会被取消。
 *
 * 输入
 * 4个非负整数a, b, c, da,b,c,d，以空格分隔。
 *
 * 数据范围: 0 \le a,b,c,d \le 10000000, a+b+c+d \ge 10≤a,b,c,d≤10000000,a+b+c+d≥1
 * 输出
 * 2^n2
 * n
 *  种可能里，活动被取消的情况数量。答案可能很大，请输出答案除以 998244353 之后的余数。
 *
 * 输入样例
 * 1 1 1 1
 *
 * 输出样例
 * 12
 *
 *
 * Created by zhouyanhui on 2019/12/1.
 */
import java.util.*;

public class Main {
    private static final int M = 998244353;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] s = line.split(" ", 4);
            int a = Integer.valueOf(s[0]);
            int b = Integer.valueOf(s[1]);
            int c = Integer.valueOf(s[2]);
            int d = Integer.valueOf(s[3]);
            System.out.println(solution(a,b,c,d));
        }
    }

    private static long solution(int a, int b, int c, int d) {
        //      取消情况  2^n - 2^a*((2^b-1-b)*(2^(c+d)-1) + b*(2^d-1)*2^c + (2^d-1-d)*2^c )
        //      =  2^(b+a) + (b+d+1)*2^(c+a)-b*2^a-2^a
        long res = mod(calcPowMod(b+a) + mod(b+d+1)*calcPowMod(c+a))
                - mod((b+1) * calcPowMod(a));
        return mod(res);
    }

    private static long mod(long n){
        if(n < 0){
            n+=M;
        }
        return n %M;
    }

    private static long calcPowMod(int n) {
        long s = 2, res = 1;
        while(n>0){
            if((n&1) == 1){
                res = (res * s) % M;
                n--;
            }else{
                s = (s * s) % M;
                n/=2;
            }
        }
        return res;
    }
}

