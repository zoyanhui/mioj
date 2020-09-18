package mine.code.mioj._54_Sudoku;

/**
 * - 数独游戏
 * 序号：#54
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 数独盘面是个九宫，每一宫又分为九个小格。在这八十一格中给出一定的已知数字和解题条件，利用逻辑和推理，在其他的空格上填入1-9的数字。使1-9每个数字在每一行、每一列和每一宫中都只出现一次，所以又称"九宫格"。 一个合法的数独棋盘满足上面的条件，即1-9每个数字在每一行、每一列和每一宫中都只出现一次，而并不要求一定有解。 请判断给出的数独棋盘是否合法。
 *
 * 举例： 有一个数独棋盘如下：
 *
 * 5 3 - - 7 - - - -
 * 6 - - 1 9 5 - - -
 * - 9 8 - - - - 6 -
 * 8 - - - 6 - - - 3
 * 4 - - 8 - 3 - - 1
 * 7 - - - 2 - - - 6
 * - 6 - - - - 2 8 -
 * - - - 4 1 9 - - 5
 * - - - - 8 - - 7 9
 * 它是一个合法棋盘，输出true。
 *
 * 输入
 * 从左到右从上到下，使用空格分隔每一宫，使用逗号分隔每一格，没有数字则代表该格为空。
 *
 * 输出
 * true或false表示该数独棋盘是否合法。
 *
 * 输入样例
 * 5,3,-,6,-,-,-,9,8 -,7,-,1,9,5,-,-,- -,-,-,-,-,-,-,6,- 8,-,-,4,-,-,7,-,- -,6,-,8,-,3,-,2,- -,-,3,-,-,1,-,-,6 -,6,-,-,-,-,-,-,- -,-,-,4,1,9,-,8,- 2,8,-,-,-,5,-,7,9
 * 5,3,-,6,-,-,-,9,8 -,7,-,1,9,5,-,-,- -,-,-,-,-,-,-,6,- 8,-,-,4,-,-,7,-,- -,6,-,8,-,3,-,2,- -,-,3,-,-,1,-,-,6 -,6,-,-,-,-,-,9,- -,-,-,4,1,9,-,8,- 2,8,-,-,-,5,-,7,9
 *
 * 输出样例
 * true
 * false
 * Created by zhouyanhui on 2019/11/19.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            boolean answer = solution(line);
            System.out.println(answer);
        }
    }

    private static boolean solution(String line) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        String[] cells = line.split(" ", 9);
        for (int i = 0; i < cells.length; i++) {
            String[] cs = cells[i].split(",");
            boolean[] existed = new boolean[9];
            for (int j = 0; j < cs.length; j++) {
                if(cs[j].equalsIgnoreCase("-")){
                    continue;
                }
                int n = cs[j].charAt(0) - '0' - 1;
                if(existed[n]){
                    return false;
                }
                existed[n] = true;
                int cellStart = 27 * (i / 3) + 3 * (i % 3);
                int idxInCell = 9 * (j / 3) + j % 3;
                int idx = cellStart + idxInCell;
                if(rows[idx/9][n] || cols[idx%9][n]){
                    return false;
                }
                rows[idx/9][n] = true;
                cols[idx%9][n] = true;
            }
        }
        return true;
    }
}
            
