package mine.code.mioj._71_StringAgain;

/**
 * - 还是字符串
 * 序号：#71
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 有一个无限长的字符串，只包含数字 1 和 2 ，按照一定的规则变化后，字符串不会发生任何变化。规则如下： 将字符串按1与2进行拆解，计算相邻的1与2的数量，组成的新字符串。
 *
 * 下面是这个字符串的前19位： 1221121221221121122...... 按1与2拆解，可得： (1) (22) (11) (2) (1) (22) (1) (22) (11) (2) (11) (22) ...... 计算相邻的1与2的数量，组成的新字符串： 1 2 2 1 1 2 1 2 2 1 2 2 ...... 恰好等于原字符串。字符串不变。
 *
 * 输入
 * 输入正整数 Ｎ，表示这个无限长字符串的前N位子串的长度 例如Ｎ＝6，前6位子串为 122112
 *
 * 输出
 * 正整数 M，表示前N位子串中1的个数
 *
 * 输入样例
 * 4
 * 5
 * 6
 *
 * 输出样例
 * 2
 * 3
 * 3
 *
 *
 * Created by zhouyanhui on 2019/11/24.
 */

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int N = Integer.valueOf(line);
            System.out.println(solution(N));
        }
    }

    private static int solution(int n) {
        if(n <= 3){
            return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        int m = 1, c = 3, cur = 2;
        while(c < n){
            int next = queue.poll();
            c+=next;
            if(next == 1){
                if(cur == 1){
                    cur = 2;
                    queue.add(2);
//                    System.out.printf("%d,", 2);
                }else{
                    cur = 1;
                    queue.add(1);
//                    System.out.printf("%d,", 1);
                    m++;
                }
            }else{
                if(cur == 1){
                    queue.add(2);
                    queue.add(2);
//                    System.out.printf("%d,%d,", 2,2);
                    cur = 2;
                }else{
                    cur = 1;
                    queue.add(1);
                    queue.add(1);
//                    System.out.printf("%d,%d,", 1,1);
                    m+=2;
                }
            }
        }
        if(c > n){
            if(cur == 1){
                m--;
            }
        }
        return m;
    }
}

