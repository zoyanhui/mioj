package mine.code.mioj._59_DriftingBottle;

/**
 * - 漂流瓶
 * 序号：#59
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 老板要宣传公司新产品，决定在将广告放在漂流瓶扔在大海里。 用数组表示大海水位的高度，比如：
 * \begin{bmatrix} 1 &amp; 2 &amp; 2 &amp; 3 &amp; 5 \\ 3 &amp; 2 &amp; 3 &amp; 4 &amp; 4 \\ 2 &amp; 4 &amp; 5 &amp; 3 &amp; 1 \\ 6 &amp; 7 &amp; 1 &amp; 4 &amp; 5 \\ 5 &amp; 1 &amp; 1 &amp; 2 &amp; 4 \\ \end{bmatrix}
 * ​
 *
 * 其中左边界和上边界表示太平洋，右边界和下边界表示大西洋。左下与右上两个重合点既是太平洋也在大西洋。 将漂流瓶扔到大海里，漂流瓶会随机向上下左右四个方向漂流，但是只能漂向水位低于或等于当前水位的方向。
 *
 * 请输出所有符合以下条件的位置坐标：将漂流瓶从这个位置丢下，既可能漂到太平洋，又可能漂到大西洋。
 *
 * 输入
 * 一个二维整数矩阵，表示海域水位高低情况。
 *
 * 输出
 * 符合条件的位置坐标，每行 1 个，并使用空格分隔坐标的 x 与 y 值。
 *
 * 输入样例
 * 1 2 2 3 5
 * 3 2 3 4 4
 * 2 4 5 3 1
 * 6 7 1 4 5
 * 5 1 1 2 4
 *
 * 9 8 7 6 11
 * 7 1 1 1 10
 * 8 1 1 1 10
 * 9 10 1 1 10
 * 11 8 9 9 9
 *
 * 输出样例
 * 0 4
 * 1 3
 * 1 4
 * 2 2
 * 3 0
 * 3 1
 * 4 0
 *
 * 0 4
 * 3 1
 * 4 0
 *
 *
 * Created by zhouyanhui3 on 19-11-21.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        ArrayList<int[]> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if(line.isEmpty()){
                break;
            }
            int[] ints = splitToInts(line, " ");
            list.add(ints);
        }
        int[][] array = list.toArray(new int[0][]);
        List<String> answer = solution(array);
        for (String s : answer) {
            System.out.println(s);
        }
    }

    private static List<String> solution(int[][] array) {
        byte[][] flags = new byte[array.length][array[0].length];
        for (int i = 0; i < array[0].length; i++) {
            flags[0][i] |= 0x01; // 上太平洋
            flags[array.length-1][i] |= 0x02; // 下大西洋
        }
        for (int i = 0; i < array.length; i++) {
            flags[i][0] |= 0x01; // 左太平洋
            flags[i][array[0].length-1] |= 0x02; // 右大西洋
        }
        int[][] directors = new int[][]{{0,-1}, {0, 1}, {-1,0}, {1, 0}};
        for (int i = 0; i < array[0].length; i++) {
            walk(array, 0, i, directors, flags);
            walk(array, array.length - 1, i, directors, flags);
        }
        for (int i = 0; i < array.length; i++) {
            walk(array, i, 0, directors, flags);
            walk(array, i, array[0].length - 1, directors, flags);
        }
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(flags[i][j] == 3){
                    answer.add(i + " " + j);
                }
            }
        }
        return answer;
    }

    private static void walk(int[][] array, int i, int j, int[][] directors, byte[][] flags) {
        if(i < 0 || i >= array.length || j < 0 || j >= array[0].length){
            return;
        }
        for (int k = 0; k < directors.length; k++) {
            int ni = i + directors[k][0];
            int nj = j + directors[k][1];
            if(ni < 0 || ni >= array.length || nj < 0 || nj >= array[0].length){
                continue;
            }
            if(flags[ni][nj] == flags[i][j]){
                continue;
            }
            if(array[ni][nj] >= array[i][j]){
                flags[ni][nj] |= flags[i][j];
                walk(array, ni, nj, directors, flags);
            }
        }
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

