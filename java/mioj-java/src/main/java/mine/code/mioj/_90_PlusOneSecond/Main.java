package mine.code.mioj._90_PlusOneSecond;

/**
 * - +1s
 * 序号：#90
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 在某个古老的神秘国度，有一位长者，他有一项特殊的能力，那就是能为自己的生命续一秒，与此同时，周围的人会相应的-1s
 *
 * 每当电子表的小时数与分钟数一样时(24小时制，00:00:00~23:59:59)，那1分钟的最后1秒将会消失不见
 *
 * 也就是说，比如，06:06:58的下一秒将是06:07:00
 *
 * 现在，与长者共处了一段时间后，对于你来说，你度过的时间究竟是多少
 *
 * 输入
 * 现实世界中经过的时间，格式为{天}d{小时} {分} {秒}，时分秒补足2位
 *
 * 输出
 * 对于你而言的时间，格式同输入
 *
 * 输入样例
 * 2d06 05 24
 * 69d04 29 05
 * 54d20 20 36
 * 0d00 00 59
 * 0d00 00 58
 * 8d12 13 05
 *
 * 输出样例
 * 2d06 04 30
 * 69d04 01 24
 * 54d19 58 40
 * 0d00 00 58
 * 0d00 00 58
 * 8d12 09 40
 *
 * Created by zhouyanhui on 2019/11/30.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
        }
    }

    private static String solution(String line) {
        String[] s = line.split(" ", 3);
        String[] ds = s[0].split("d", 2);
        int days = Integer.valueOf(ds[0]);
        int hours = parseNum(ds[1]);
        int minutes = parseNum(s[1]);
        int seconds = parseNum(s[2]);
        long totalSeconds = 24 * 3600 * days + 3600 * hours + 60 * minutes + seconds;
        int detalSeconds = 24 * days + hours;
        if(minutes >= hours + 1){
            detalSeconds += 1;
        }else{
            if(seconds == 59){
                detalSeconds += 1;
            }
        }
        long passSeconds = totalSeconds - detalSeconds;
        int passDays = (int)(passSeconds / (24 * 3600));
        passSeconds -= 24 * 3600 * passDays;
        int passHours = (int)(passSeconds / 3600);
        passSeconds -= 3600 * passHours;
        int passMinutes = (int)(passSeconds / 60);
        passSeconds -= 60 * passMinutes;
        return String.format("%dd%s %s %s", passDays, toStr(passHours), toStr(passMinutes), toStr((int)passSeconds));
    }

    private static String toStr(int passNum) {
        if(passNum < 10){
            return "0" + passNum;
        }
        return String.valueOf(passNum);
    }

    private static int parseNum(String d) {
        if(d.startsWith("0")){
            return Integer.valueOf(d.substring(1));
        }else{
            return Integer.valueOf(d);
        }
    }
}

