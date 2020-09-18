package mine.code.mioj._41_CoinSort;

/**
 * - 硬币排序
 * 序号：#41
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：15M
 * 描述
 * 小明目前在一家银行的IT部门工作。 银行每天经常会有很多存款业务，所以每天总会收到大量硬币。如何给这些硬币分类排序成了令业务部门十分头疼的一个问题。 这一天，业务部门向IT部门提交了一个需求，希望IT部门能够出一套为硬币进行排序的解决方案，使得面值小的硬币排到前面，其中最核心的算法部门交给了小明来实现。 如果你是小明，你会给出一个什么样的算法呢？
 *
 * 注： 1.要求不使用任何系统排序函数或库排序函数！！！ 2.要求时间复杂度为O(n)，空间复杂度为O(1)，也就是不允许建立新数组，只能在原数组上进行排序！！！
 *
 * 输入
 * 一个字符串，只包含a、b、c三种字符，分别表示1元，2元，5元三种硬币
 *
 * 输出
 * 一个字符串，已按照a、b、c完成排序，表示经过排序后的一排硬币
 *
 * 输入样例
 * cba
 * acba
 *
 * 输出样例
 * abc
 * aabc
 *
 * Created by zhouyanhui on 2019/11/17.
 */
import java.util.*;

public class Main {
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
        long[] count = new long[3];
        for (int i = 0; i < line.length(); i++) {
            count[line.charAt(i) - 'a'] += 1;
        }
        line = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count[0]; i++) {
            sb.append('a');
        }
        for (int i = 0; i < count[1]; i++) {
            sb.append('b');
        }
        for (int i = 0; i < count[2]; i++) {
            sb.append('c');
        }
        return sb.toString();
    }
}

