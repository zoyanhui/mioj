package mine.code.mioj._38_SonInLawOfKing;

/**
 * - 国王招驸马
 * 序号：#38
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 国王为了给公主找到这个世界上最聪明的人作为驸马，发明了一个游戏。在游戏中，国王设置了多个连续的屋子，从第一个屋子开始，每个屋子都会有n(n>=0)个门来进入接下来的1~n个屋子（例如这个屋子有2个门，那么就是第一个门可以进入之后第一个屋子，第二个门可以进入之后第二个屋子）， 最后经过屋子最少的人将获得胜利，迎娶美丽的公主。
 *
 * 输入
 * 一组数据，分别用(,)隔开，每一个数字表示对应的屋子共有多少扇门。
 *
 * 输出
 * 一个整数，表示到达最后屋子时经过的最少的屋子数，如果不能到达则返回-1。
 *
 * 输入样例
 * 2,3,1,1,4
 * 1,1,1,0,1
 *
 * 输出样例
 * 2
 * -1
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
            int answer = solution(line);
            System.out.println(answer);
        }
    }

    private static int solution(String line) {
        int[] ints = splitToInts(line, ",");
        return goNext(ints, 0);
    }

    private static int goNext(int[] ints, int now) {
        if(now == ints.length - 1){
            return 0;
        }
        if(now >= ints.length){
            return -1;
        }
        int min = ints.length;
        for (int i = 1; i <= ints[now]; i++) {
            int steps = goNext(ints, now + i);
            if(steps >= 0){
                steps += 1;
                min = steps > min ? min : steps;
            }
        }
        return min >= ints.length ? -1 : min;
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

