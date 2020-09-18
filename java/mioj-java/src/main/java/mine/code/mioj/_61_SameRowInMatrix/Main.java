package mine.code.mioj._61_SameRowInMatrix;

/**
 * - 找出矩阵中相同的行
 * 序号：#61
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给一个由 0 和 1 组成的矩阵，其中有两行相同，仅通过遍历找到相同的行。输出行数。
 *
 * 如：
 * \begin{bmatrix} 1 &amp; 0 &amp; 0 &amp; 1 &amp; 0 \\ 0 &amp; 1 &amp; 1 &amp; 0 &amp; 0 \\ 1 &amp; 0 &amp; 0 &amp; 1 &amp; 0 \\ 0 &amp; 0 &amp; 1 &amp; 1 &amp; 0 \\ 0 &amp; 1 &amp; 0 &amp; 0 &amp; 0 \\ \end{bmatrix}
 * ​
 *
 * 输出重复的行号为 1 和 3（行号从1开始）
 *
 * 输入
 * 单组数据。表示由0和1组成的矩阵，使用换行符分隔行，使用空格分隔每行内的元素。
 *
 * 矩阵必然存在且只有一对重复的行。
 *
 * 输出
 * 输出 1 行，使用空格分隔代表行号的两个整数，表示重复的两行。
 *
 * 输入样例
 * 1 0 0 1 0
 * 0 1 1 0 0
 * 1 0 0 1 0
 * 0 0 1 1 0
 * 0 1 0 0 0
 *
 * 输出样例
 * 1 3
 *
 * Created by zhouyanhui on 2019/11/23.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> lines = new HashMap<>();
        int i = 0;
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            i++;
            if(line.isEmpty()){
                break;
            }
            if(lines.containsKey(line)){
                System.out.println(String.format("%d %d", lines.get(line), i));
            }
            lines.put(line, i);
        }
    }
}

