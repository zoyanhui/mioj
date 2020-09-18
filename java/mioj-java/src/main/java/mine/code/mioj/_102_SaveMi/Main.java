package mine.code.mioj._102_SaveMi;

/**
 *  解救我 mi
 * 序号：#102
 * 难度：一般
 * 时间限制：300ms
 * 内存限制：32M
 * 描述
 * 给定一个只包含小写字母的字符串，现在我 mi 被众友商品牌的字符串围困在其中，需要我们将字符串中的 mi 全部移除然后输出，保证最后输出的字符串中没有 "mi"。
 *
 * 输入
 * 一行数据包含一个字符串，长度 <= 100000，字符串仅包含小写字母。
 *
 * 输出
 * 输出处理后的字符串
 *
 * 输入样例
 * huaweimivivo
 * chuizimmmiioppo
 * samsungmimiapple
 *
 * 输出样例
 * huaweivivo
 * chuizimoppo
 * samsungapple
 *
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
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == 'm'){
                stack.push(c);
                continue;
            }
            if(c == 'i'){
                if(stack.isEmpty()){
                    res.append(c);
                }else{
                    stack.pop();
                }
            }else{
                if(!stack.isEmpty()) {
                    for (int j = 0; j < stack.size(); j++) {
                        res.append('m');
                    }
                    stack.clear();
                }
                res.append(c);
            }
        }
        if(!stack.isEmpty()) {
            for (int j = 0; j < stack.size(); j++) {
                res.append('m');
            }
            stack.clear();
        }
        return res.toString();
    }
}

