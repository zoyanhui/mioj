package mine.code.mioj._84_ADC;

/**
 * - 论 ADC 如何出装
 * 序号：#84
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 每次打 ADC 时，都会纠结是出『暗影战斧』还是『破甲弓』，现在给出护甲的计算公式、当前英雄等级、对方英雄护甲，你可以计算出买哪个装备单次攻击伤害更高嘛?
 *
 * 首先，我们计算对方英雄的 护甲值： 护甲值 = 原始护甲值 - 护甲穿透。
 *
 * 然后，我们计算护甲可以提供的 伤害减免，伤害减免公式为： 伤害减免 = (护甲值) / (602 + 护甲值)。
 *
 * 英雄的 攻击力 为： 100 + 装备攻击
 *
 * 实际英雄受的伤害为： 攻击力 x (100% - 伤害减免)
 *
 * 装备属性如下：
 *
 * 暗影战斧 axe +85 物理攻击 唯一被动（切割）：增加（100+英雄等级*10）点护甲穿透
 *
 * 破甲弓 bow +80 物理攻击 唯一被动：增加 45% 护甲穿透（实际穿透的护甲值为 原始护甲 x ( 1 - 45%) ）
 *
 * 输入
 * 一行数字，每行两个数（空格隔开）：x y（己方英雄等级 对方英雄护甲）。
 *
 * 输出
 * 如果『暗影战斧』伤害更高，那么输出 axe，如果『破甲弓』更优秀，那么输出 bow。 如果两个一样，那么输出 same。
 *
 * 输入样例
 * 15 100
 * 0 1000
 * 0 200
 *
 * 输出样例
 * axe
 * bow
 * axe
 *
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
            String[] s = line.split(" ", 2);
            System.out.println(solution(Integer.valueOf(s[0]), Integer.valueOf(s[1])));
        }
    }

    private static String solution(int a, int b) {
        double axeArmo = b - (100 + a * 10);
        double axe = (100 + 85) * (1.0 - axeArmo / (602 + axeArmo));
        double bowArmo = b * (1.0 - 0.45);
        double bow = (100 + 80) * (1 - bowArmo / (602 + bowArmo));
        int compare = Double.compare(axe, bow);
        if(compare > 0){
            return "axe";
        }else if(compare < 0){
            return "bow";
        }else{
            return "same";
        }
    }
}

