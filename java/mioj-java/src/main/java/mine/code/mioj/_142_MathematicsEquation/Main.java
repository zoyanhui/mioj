package mine.code.mioj._142_MathematicsEquation;

/**
 * - 数学等式
 * 序号：#142
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：64M
 * 描述
 * 现有等式
 *
 * a \cdot {x_1}^3 + b \cdot {x_2}^3 + c \cdot {x_3}^3 = d \cdot {x_4}^3 + e \cdot {x_5}^3
 * a⋅x
 * 1
 * ​
 *
 * 3
 *  +b⋅x
 * 2
 * ​
 *
 * 3
 *  +c⋅x
 * 3
 * ​
 *
 * 3
 *  =d⋅x
 * 4
 * ​
 *
 * 3
 *  +e⋅x
 * 5
 * ​
 *
 * 3
 *
 * 其中 a, b, c, d, ea,b,c,d,e 满足 -50 \le a,b,c,d,e,x \le 50−50≤a,b,c,d,e,x≤50 且皆为整数，且 a, b, c, d, e \ne 0, x \ne 0a,b,c,d,e
 * ̸
 * ​
 *  =0,x
 * ̸
 * ​
 *  =0
 * 给出 a,b,c,d,ea,b,c,d,e ,求出满足等式成立的x_1,x_2,x_3,x_4,x_5x
 * 1
 * ​
 *  ,x
 * 2
 * ​
 *  ,x
 * 3
 * ​
 *  ,x
 * 4
 * ​
 *  ,x
 * 5
 * ​
 *  （均为整数）的组数。
 *
 * 输入
 * 五个整数 a,b,c,d,ea,b,c,d,e
 * 输出
 * 满足等式成立的数据的组数
 *
 * 输入样例
 * -14 -42 -23 27 -48
 *
 * 输出样例
 * 3022
 *
 *
 *
 * Created by zhouyanhui on 2019/12/7.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
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


    static int solution(String line) {
        int[] ints = splitToInts(line, " ");
        int[] cubes = new int[101];
        for (int i = -50; i <= 50 ; i++) {
            cubes[i+50] = i*i*i;
        }
        int[] right = new int[10000];
        int k = 0;
        for (int i = 0; i < cubes.length; i++) {
            if(i == 50){
                continue;
            }
            for (int j = 0; j < cubes.length; j++) {
                if(j == 50){
                    continue;
                }
                right[k++] = ints[3] * cubes[i] + ints[4] * cubes[j];
            }
        }
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int i = 0; i < cubes.length; i++) {
            if(i == 50){
                continue;
            }
            for (int j = 0; j < cubes.length; j++) {
                if(j == 50){
                    continue;
                }
                for (int l = 0; l < cubes.length; l++) {
                    if(l == 50){
                        continue;
                    }
                    int val = ints[0] * cubes[i] + ints[1] * cubes[j] + ints[2] * cubes[l];
                    int old  = leftMap.getOrDefault(val, 0);
                    leftMap.put(val, old + 1);
                }
            }
        }
        int c = 0;
        for (int i = 0; i < right.length; i++) {
            c += leftMap.getOrDefault(right[i], 0);
        }
        return c;
    }
}

