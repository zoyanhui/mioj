package mine.code.mioj.bigIntegerMinus;

import java.util.*;

/**
 * 描述
 * 两个长度超出常规整形变量上限的大数相减，请避免使用各语言内置大数处理库，如 Java.math.BigInteger 等。
 *
 * 输入
 * 有 N 行测试数据，每一行有两个代表整数的字符串 a 和 b，长度超过百位。规定 a>=b，a, b > 0。 测试结果可以用 linux 小工具 bc进行测试是否正确。
 *
 * 输出
 * 返回表示结果整数的字符串。
 *
 * 输入样例
 * 1231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739870-89513312312312378127398789513312312312378127398789513312312312378127398789513
 * 1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001-331231231237812739878951331231231
 *  复制样例
 * 输出样例
 * 1231231237812739878951331231231237812739878951331231231237812650365639018918853110413950365639018918853110413950365639018918853110413950357
 * 1231231237812739878951331231231237812739878951331231231237812739878620099998762187260121048668768770
 *
 *
 * Created by zhouyanhui3 on 19-10-25.
 */
public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int lenA = line.indexOf("-");
            int len = line.length();
            int flag = 0;
            StringBuilder result = new StringBuilder();
            int i = lenA - 1, j = len - 1;
            while(true){
                if(i < 0 || j <= lenA){
                    break;
                }
                flag = minusOnePos(line, result, i, j, flag);
                i--;
                j--;
            }
            while (i >= 0){
                flag = minusOnePos(line, result, i, flag);
                i--;
            }
            while(j > lenA){
                flag = minusOnePos(line, result, j, flag);
                j--;
            }
            if(flag != 0){
                System.out.println("input wrong");
            }else {
                for (int k = result.length()-1; k >=0; k--) {
                    if(result.charAt(k) != '0'){
                        break;
                    }
                    result.deleteCharAt(k);
                }
                if(result.length() == 0){
                    System.out.println(0);
                }else {
                    System.out.println(result.reverse().toString());
                }
            }
        }
    }

    private static int minusOnePos(String line, StringBuilder result, int p, int flag){
        char pos = (char) (line.charAt(p) - flag);
        if(pos < '0'){
            pos += 10;
            flag = 1;
        }else{
            flag = 0;
        }
        result.append(pos);
        return flag;
    }

    private static int minusOnePos(String line, StringBuilder result, int pA, int pB, int flag){
        char pos = (char) (line.charAt(pA) - line.charAt(pB) + '0' - flag);
        if(pos < '0'){
            pos += 10;
            flag = 1;
        }else{
            flag = 0;
        }
        result.append(pos);
        return flag;
    }
}
