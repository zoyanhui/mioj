package mine.code.mioj.LowercaseNumberToUpercase;

/**
 * - 小写数字转大写数字
 * 序号：#17
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 实现一个算法，可以将小写数字转换成大写数字。
 *
 * 输入
 * 输入一个整数。范围在0～450亿之间。
 *
 * 输出
 * 输出对应的大写数字，以“元整”结尾。 大写数字要符合汉语读写习惯。
 *
 * 输入样例
 * 0
 * 5
 * 233
 * 1001
 * 40607
 * 8900000000
 *
 * 输出样例
 * 零元整
 * 伍元整
 * 贰佰叁拾叁元整
 * 壹仟零壹元整
 * 肆万零陆佰零柒元整
 * 捌拾玖亿元整
 * Created by zhouyanhui3 on 19-11-6.
 */
import java.util.*;

public class Main {
    private static final String[] numDict = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
    private static final int yi = 100000000;
    private static final int wan = 10000;
    private static final int qian = 1000;
    private static final int bai = 100;
    private static final int shi = 10;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String answer = solution(line);
            System.out.println(answer);
        }
    }

    private static String solution(String line) {
        long num = Long.valueOf(line);
        StringBuilder stringBuilder = new StringBuilder();
        boolean isTop = true;
        long yiNum = num / yi;
        if(yiNum > 0){
            buildNum(yiNum, stringBuilder, isTop);
            isTop = false;
            stringBuilder.append("亿");
        }
        num %= yi;
        long wanNum = num / wan;
        if(wanNum > 0){
            buildNum(wanNum, stringBuilder, isTop);
            isTop = false;
            stringBuilder.append("万");
        }
        num %= wan;
        buildNum(num, stringBuilder, isTop);
        if(stringBuilder.length() == 0){
            stringBuilder.append("零");
        }
        stringBuilder.append("元整");
        return stringBuilder.toString();
    }

    private static void buildNum(long yiNum, StringBuilder stringBuilder, boolean top) {
        if(yiNum == 0){
            return;
        }
        int num = (int)yiNum;
        int qianNum = (int)num / qian;
        if(qianNum > 0){
            stringBuilder.append(numDict[qianNum]).append("仟");
        }
        num %= qian;
        int baiNum = num / bai;
        if(baiNum > 0){
            if(!top && qianNum == 0){
                stringBuilder.append("零");
            }
            stringBuilder.append(numDict[baiNum]).append("佰");
        }
        num %= bai;
        int shiNum = num / shi;
        if(shiNum > 0){
            if(baiNum == 0){
               if(qianNum > 0 || !top){
                   stringBuilder.append("零");
               }
            }
            stringBuilder.append(numDict[shiNum]).append("拾");
        }
        num %= shi;
        if(num > 0){
            if(shiNum == 0){
                if(baiNum > 0 || qianNum > 0 || !top){
                    stringBuilder.append("零");
                }
            }
            stringBuilder.append(numDict[num]);
        }
    }
}
