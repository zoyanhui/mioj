package mine.code.mioj._86_ExcellentNumber;

/**
 * - 优秀数字
 * 序号：#86
 * 难度：一般
 * 时间限制：300ms
 * 内存限制：10M
 * 描述
 * 判断一个数字是否为优秀数字。优秀数字定义为，一个整数M(M>=0)，有2条规则： 规则1：存在一个正整数N(N>=0)，使得M=2^N+1； 规则2：存在一个正整数N(N>=0)，使得M=2^N-1； 若同时满足规则1和规则2，则输出Very Good 若满足规则1而不满足规则2，则输出Good 若不满足规则1而满足规则2，则输出Bad 若都不满足，则输出Normal
 *
 * 输入
 * 一个整数M(M>=0)
 *
 * 输出
 * 输出该数属于的类型
 *
 * 输入样例
 * 3
 * 5
 * 7
 * 8
 *
 * 输出样例
 * Very Good
 * Good
 * Bad
 * Normal
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
            long M = Long.valueOf(line);
            System.out.println(solution(M));
        }
    }

    private static String solution(long m) {
        boolean up = false, down = false;
        int n = 0;
        while(true){
            long pow = (long) Math.pow(2, n);
            if(pow + 1 == m){
                up = true;
            }
            if(pow - 1 == m){
                down = true;
            }
            if(pow > m){
                break;
            }
            n++;
        }
        if(up && down){
            return "Very Good";
        }else if(up){
            return "Good";
        }else if(down){
            return "Bad";
        }else{
            return "Normal";
        }
    }
}

