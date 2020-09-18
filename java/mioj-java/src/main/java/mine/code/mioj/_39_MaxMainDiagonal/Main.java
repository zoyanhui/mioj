package mine.code.mioj._39_MaxMainDiagonal;

/**
 * - 寻找最大主对角线的和
 * 序号：#39
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 任意给一个m*n矩阵(m>=2, n>=2)，元素均为非负数，请找出其中主对角线和最大的二阶子矩阵，求出主对角线和。（主对角线：一个n维矩阵的主对角线为所有第k行第k列元素的全体，k=1, 2, 3… n，即从左上到右下的一条斜线）
 *
 * 举例： 有一个3*5的矩阵如下： 3 3 1 3 4 5 5 7 10 1 2 9 5 3 3 其中，主对角线和最大的二阶子矩阵是: 5 5 2 9 可得出其主对角线和为14
 *
 * 输入
 * 单组数据。 输入一个 m*n (1 < m < 50, 1 < n < 50)矩阵，每行有 n 个整数，共 m 行.
 *
 * 输出
 * 一个整数，表示最大的主对角线和
 *
 * 输入样例
 * 3 3 1 3 4
 * 5 5 7 10 1
 * 2 9 5 3 3
 *
 * 输出样例
 * 14
 * Created by zhouyanhui on 2019/11/17.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        List<int[]> rows = new ArrayList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if(line.isEmpty()){
                break;
            }
            int[] ints = splitToInts(line, " ");
            rows.add(ints);
        }
        int answer = solution(rows);
        System.out.println(answer);
    }

    private static int solution(List<int[]> rows) {
        int max = 0;
        for (int i = 0; i < rows.size() - 1; i++) {
            for (int j = 0; j < rows.get(i).length - 1; j++) {
                int cur = rows.get(i)[j] + rows.get(i + 1)[j+ 1];
                max = cur > max ? cur : max;
            }
        }
        return max;
    }

    private static int[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        int[] ret = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = Integer.valueOf(split[i]);
        }
        return ret;
    }
}

