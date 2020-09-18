package mine.code.mioj._96_NthUlgyNumber;

/**
 * - 第N个丑数
 * 序号：#96
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 输入
 * 输入一个正整数N，0<N<10000
 *
 * 输出
 * 输出一个正整数S，S为第N个丑数
 *
 * 输入样例
 * 1
 * 2
 * 10
 * 100
 * 10000
 *
 * 输出样例
 * 1
 * 2
 * 12
 * 1536
 * 288325195312500000
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
            int N = Integer.valueOf(line);
            System.out.println(solution(N));
        }
    }

    private static long solution(int n) {
        if(n == 1){
            return 1;
        }
        List<Long> list = new ArrayList<>();
        list.add(1l);
        long cur = 1;
        int i = 0, j = 0, k = 0;
        int m  = 0;
        while(m < n-1){
            long[] ints = calcNext(cur, list, i, 2);
            long two = ints[0];
            i = (int)ints[1];
            ints = calcNext(cur, list, j, 3);
            long three = ints[0];
            j = (int)ints[1];
            ints = calcNext(cur, list, k, 5);
            long five = ints[0];
            k = (int)ints[1];
//            if(two == Long.MAX_VALUE && two == three && three == five){
//                continue;
//            }
            if(two <= three && two <= five){
                list.add(two);
                cur = two;
                i++;
            }else if(three <= two && three <= five){
                list.add(three);
                cur = three;
                j++;
            }else {
                list.add(five);
                cur = five;
                k++;
            }
            m++;
        }
        return cur;
    }

    private static long[] calcNext(long cur, List<Long> list, int i, int mult) {
        long next = i == list.size() ? Long.MAX_VALUE : mult * list.get(i);
        while(i < list.size() && next <= cur){
            i++;
            next = i == list.size() ? Long.MAX_VALUE : mult * list.get(i);
        }
        return new long[]{next, i};
    }
}

