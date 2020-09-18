package mine.code.mioj._136_TraceOfMiTu;

/**
 * - 小米兔的轨迹
 * 序号：#136
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：80M
 * 描述
 * 有 N \cdot MN⋅M 的一个矩阵，小米兔今天很开心，从矩阵左上角的第一个位置开始顺时针从外向里走，很快就走遍了所有的位置，可是小米兔想知道自己走过的轨迹，你能告诉小米兔它走过的轨迹吗？
 *
 * （输出一个字符串，由小米兔走过的位置的值组成，用空格分隔。）
 *
 * 输入
 * 单组输入。
 *
 * 第 1 行是 2 个整数，分别代表 NN 和 MM 的值；
 * 第 2 ~ NN + 1 行，表示 N \cdot MN⋅M 的矩阵中的每一行。
 * 输出
 * 输出为一个字符串，由小米兔走过的位置的值组成，用空格分隔。
 *
 * 输入样例
 * 3 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 4 5
 * 1 2 3 4 5
 * 14 15 16 17 6
 * 13 20 19 18 7
 * 12 11 10 9 8
 *
 * 3 4
 * 1 2 3 4
 * 10 11 12 5
 * 9 8 7 6
 *
 * 4 3
 * 1 2 3
 * 10 11 4
 * 9 12 5
 * 8 7 6
 *
 * 5 4
 * 1 2 3 4
 * 14 15 16 5
 * 13 20 17 6
 * 12 19 18 7
 * 11 10 9 8
 *
 * 6 6
 * 1 2 3 4 5 6
 * 20 21 22 23 24 7
 * 19 32 33 34 25 8
 * 18 31 36 35 26 9
 * 17 30 29 28 27 10
 * 16 15 14 13 12 11
 *
 * 输出样例
 * 1 2 3 6 9 8 7 4 5
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 * 1 2 3 4 5 6 7 8 9 10 11 12
 * 1 2 3 4 5 6 7 8 9 10 11 12
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 *
 * Created by zhouyanhui on 2019/12/1.
 */

import java.util.Scanner;

public class BetterMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        line = scan.nextLine().trim();
        String[] s = line.split(" ", 2);
        int N = Integer.valueOf(s[0]);
        int M = Integer.valueOf(s[1]);
        int[][] matrix = new int[N][M];
        int k = 0;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            String[] s1 = line.split(" ");
            int[] row = new int[s1.length];
            for (int i = 0; i < s1.length; i++) {
                row[i] = Integer.valueOf(s1[i]);
            }
            matrix[k++] = row;
        }
        System.out.println(solution(matrix));
    }

    private static String solution(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return "";
        }
        int n = matrix.length, m = matrix[0].length;
        int[] res = new int[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int loop = -1;
                if(i < n/2){
                    loop = i;
                }else{
                    loop = n-1-i;
                }
                if(j < m/2){
                    loop = Math.min(loop, j);
                }else{
                    loop = Math.min(loop, m-1-j);
                }

                int loopIdx = -1;
                int up = m - 2*loop, right = n - 2* loop -1;
                int down = m - 2*loop -1, left = n - 2*i - 2;
                if(i == loop){
                    loopIdx = j - loop;
                }else if(j == up + loop-1){
                    loopIdx = up + i - loop - 1;
                }else if(i == right+loop){
                    loopIdx = up + right + (loop + up-1-j) - 1;
                }else{
                    loopIdx = up+right+down + (loop + right - i) - 1;
                }
                if(loop ==0){
                    res[loopIdx] = matrix[i][j];
                }else{
                    res[loopIdx + loop * (2*m+2*n-4) - 8*(loop-1)*(loop)/2] = matrix[i][j];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            stringBuilder.append(res[i]).append(" ");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }
}

