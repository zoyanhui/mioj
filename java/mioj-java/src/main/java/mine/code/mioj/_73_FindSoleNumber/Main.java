package mine.code.mioj._73_FindSoleNumber;

/**
 * - 找出单独出现的数字II
 * 序号：#73
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个数组，数组中的数字皆为正整数，除了某一个数字，其他的数字都会出现三次。 找出那个只出现一次的数。
 *
 * 输入
 * 3n+1的正整数数组，使用逗号(,)分隔(n>0)
 *
 * 输出
 * 单独出现的数字
 *
 * 输入样例
 * 2,3,2,2
 * 5,1,4,5,4,5,4
 *
 * 输出样例
 * 3
 * 1
 *
 *
 * Created by zhouyanhui3 on 19-11-25.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int[] ints = splitToInts(line, ",");
            System.out.println(solution(ints));
        }
    }

    private static int solution(int[] ints) {
        Map<Integer, Boolean> existed = new HashMap<>();
        int val = 0;
        for (int i = 0; i < ints.length; i++) {
            Boolean aBoolean = existed.get(ints[i]);
            if(aBoolean == null){
                val ^= ints[i];
                existed.put(ints[i], Boolean.FALSE);
            }else if(!aBoolean){
                val ^= ints[i];
                existed.put(ints[i], Boolean.TRUE);
            }
        }
        return val;
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
