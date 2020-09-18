package mine.code.mioj._87_BeautifulString;

/**
 * - 美丽字符串
 * 序号：#87
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 定义一个美丽字符串，对于字符串S，S中只包含小写的a-z字符，存在2条规则： 规则1：S中每个字符出现的次数一样，如abc，每个字符出现1次，aabbcc，每个字符出现2次 规则2：添加或删除S中的一个字符后，使得S中每个字符出现的次数一样，如abca，删除一个字符a，则变为abc后每个字符出现1次 又例如aabcbbcc,添加一个字符a，则变为aabcbbcca，每个字符出现3次 对于字符串S，若满足规则1，2中任意一条规则，则称为美丽的字符串
 *
 * 输入
 * 一个字符串S，只包含a-z的小写字符
 *
 * 输出
 * 判断该字符串是否为美丽的字符串，若是则输出YES，若不是则输出NO
 *
 * 输入样例
 * abc
 * aabbccc
 * aaccbd
 *
 * 输出样例
 * YES
 * YES
 * NO
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
            System.out.println(solution(line));
        }
    }

    private static String solution(String line) {
        char[] alphaBetaCount = new char[26];
        for (int i = 0; i < line.length(); i++) {
            alphaBetaCount[line.charAt(i) - 'a']++;
        }
        Arrays.sort(alphaBetaCount);
        int k = 0;
        while(k < alphaBetaCount.length && alphaBetaCount[k] == 0){
            k++;
        }
        if(k == alphaBetaCount.length || k + 1 == alphaBetaCount.length){
            return "YES";
        }
        int less = alphaBetaCount[k + 1] - alphaBetaCount[k];
        if(less > 1){
            return "NO";
        }
        if(less == 1){
            for (int i = k+2; i < alphaBetaCount.length; i++) {
                if(alphaBetaCount[i] != alphaBetaCount[i-1]){
                    return "NO";
                }
            }
            return "YES";
        }else{
            int more = alphaBetaCount[alphaBetaCount.length - 1] - alphaBetaCount[alphaBetaCount.length - 2];
            if(more > 1){
                return "NO";
            }
            for (int i = alphaBetaCount.length - 3; i >= k; i--) {
                if(alphaBetaCount[i] != alphaBetaCount[i+1]){
                    return "NO";
                }
            }
            return "YES";
        }
    }
}

