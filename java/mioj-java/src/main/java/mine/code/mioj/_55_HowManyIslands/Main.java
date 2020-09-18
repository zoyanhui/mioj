package mine.code.mioj._55_HowManyIslands;


/**
 * - 数数有几个岛
 * 序号：#55
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 有一个二维的网格地图，其中1代表陆地0代表水，并且该网格的四周全部由水包围。我们对岛屿的定义是四面环水，由相邻的陆地水平或垂直连接形成，现在需要统计岛屿的数量。
 *
 * 举例： 有一个二维地图如下： 11110 11010 11000 00000 其中的岛屿数量为1。
 *
 * 输入
 * 使用空格分隔二维地图的每一行，使用逗号分隔每一项，地图范围在 1000 x 1000 以内。
 *
 * 输出
 * 岛屿的数量。
 *
 * 输入样例
 * 1,1,1,1,0 1,1,0,1,0 1,1,0,0,0 0,0,0,0,0
 * 1,1,0,0,0 1,1,0,0,0 0,0,1,0,0 0,0,0,1,1
 * 1,0,0,0,0 0,1,0,0,0 0,0,1,0,1 0,0,1,1,1
 *
 * 输出样例
 * 1
 * 3
 * 3
 *
 * Created by zhouyanhui3 on 19-11-20.
 */

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int answer = solution(line);
            System.out.println(answer);
        }
    }

    private static int solution(String line) {
        String[] split = line.split(" ");
        char[][] ints = new char[split.length][];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = splitToInts(split[i], ",");
        }
        if(ints.length == 0 || ints[0].length == 0){
            return 0;
        }
        int islandNo = 0;
        int[][] islands = new int[ints.length][ints[0].length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if(ints[i][j] == '0' || islands[i][j] > 0){
                    continue;
                }
                islandNo++;
                mark(ints, i, j, islandNo, islands);
            }
        }
        return islandNo;
    }

    private static void mark(char[][] ints, int i, int j, int islandNo, int[][] islands) {
        if(i < 0 || i >= ints.length || j < 0 || j >= ints[0].length){
            return;
        }
        if(islands[i][j] > 0){
            return;
        }
        islands[i][j] = islandNo;
        if(i < ints.length - 1 && ints[i+1][j] == '1'){
            mark(ints, i+1, j, islandNo, islands);
        }
        if(i > 0 && ints[i-1][j] == '1'){
            mark(ints, i-1, j, islandNo, islands);
        }
        if(j < ints[0].length - 1 && ints[i][j+1] == '1'){
            mark(ints, i, j+1, islandNo, islands);
        }
        if(j > 0 && ints[i][j-1] == '1'){
            mark(ints, i, j-1, islandNo, islands);
        }

    }

    private static char[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        char[] ret = new char[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = split[i].charAt(0);
        }
        return ret;
    }
}
