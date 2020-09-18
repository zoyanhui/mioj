package mine.code.mioj.constructShortString;

/**
 * - 构建短字符串
 * 序号：#11
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给定任意一个较短的子串，和另一个较长的字符串，判断短的字符串是否能够由长字符串中的字符组合出来，且长串中的每个字符只能用一次。
 *
 * 输入
 * 一行数据包括一个较短的字符串和一个较长的字符串，用一个空格分隔，如： ab aab bb abc aa cccc uak areuok
 *
 * 输出
 * 如果短的字符串可以由长字符串中的字符组合出来，返回字符串 “true”，否则返回字符串 "false"，注意返回字符串类型而不是布尔型。
 *
 * 输入样例
 * a b
 * aa ab
 * aa aab
 * uak areuok
 *
 * 输出样例
 * false
 * false
 * true
 * true
 *
 * Created by zhouyanhui3 on 19-10-31.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] s = line.split(" ");
            if(s.length < 2){
                System.out.println("wrong input");
                continue;
            }
            boolean ret = true;
            String lstr = s[s.length -1];
            for (int i = 0; i < s.length - 1; i++) {
                int[] chars = new int[256];
                for (int j = 0; j < lstr.length(); j++) {
                    chars[lstr.charAt(j)] += 1;
                }
                String sstr = s[i];
                for (int j = 0; j < sstr.length(); j++) {
                    int idx = sstr.charAt(j);
                    chars[idx] -= 1;
                    if(chars[idx] < 0){
                        ret = false;
                        break;
                    }
                }
                if(!ret){
                    break;
                }
            }
            if(ret){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}