package mine.code.mioj._110_ConversionOfNumberRadix;

/**
 *  进制转换
 * 序号：#110
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个PP进制整数NN，求NN的QQ进制表示(0 \leq N \leq 32767， 2 \leq P \leq 16, 2 \leq Q \leq 16)(0≤N≤32767，2≤P≤16,2≤Q≤16)。 大于 9 的数字依次使用小写字母 a、b、c、d、e、f 表示。 请勿使用已存在的进制转换库或函数，比如PHP中的base_convert()等。
 *
 * 输入
 * 输入3个数，以空格分隔： 第1个数是待转换的数， 第2个数是待转换的数的进制， 第3个数是转换后的数的进制。
 *
 * 输出
 * 输入转换后的数
 *
 * 输入样例
 * 31 10 16
 * 32767 16 2
 * 110100111010101 2 10
 * 131c 16 10
 *
 * 输出样例
 * 1f
 * 110010011101100111
 * 27093
 * 4892
 *
 * Created by zhouyanhui on 2019/12/1.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] s = line.split(" ", 3);
            int P = Integer.valueOf(s[1]);
            int num = toNum(s[0], P);
            int Q = Integer.valueOf(s[2]);
            System.out.println(convert(num, Q));
        }
    }

    private static int toNum(String s, int p) {
        int base = 1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num *= p;
            num += toNum(s.charAt(i));
        }
        return num;
    }

    private static int toNum(char c) {
        if(c >= '0' && c <= '9'){
            return c - '0';
        }else{
            return c - 'a' + 10;
        }
    }

    private static String convert(int num, int q) {
        StringBuilder stringBuilder = new StringBuilder();
        while(num > 0){
            stringBuilder.append(toNumStr(num % q));
            num /= q;
        }
        return stringBuilder.reverse().toString();
    }

    private static char toNumStr(int i) {
        if(i < 10){
            return (char)('0' + i);
        }
        return (char)('a' + i - 10);
    }
}

