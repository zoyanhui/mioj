package mine.code.mioj.minSwap;

/**
 * - 最少交换次数
 * 序号：#8
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个无序数列，每次只能交换相邻两个元素，求将原数列变成递增数列的最少交换次数。 如：数列：2,3,1，交换3和1后变成：2,1,3；交换1和2之后变成：1,2,3。总共交换2次。
 *
 * 输入
 * 逗号隔开的正整数数列
 *
 * 输出
 * 正整数
 *
 * 输入样例
 * 2,3,1
 *
 * 输出样例
 * 2
 * Created by zhouyanhui on 2019/11/4.
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
        List<Integer> ints = splitToInts(line, ",");
        Map<Integer, Integer> numCount = new HashMap<>();
        int maxSwap = 0;
        for (Integer anInt : ints) {
            for (Integer bInt : numCount.keySet()) {
                if(bInt > anInt){
                    maxSwap += numCount.get(bInt);
                }
            }
            Integer old = numCount.get(anInt);
            if(old == null){
                old = new Integer(1);
            }else{
                old += 1;
            }
            numCount.put(anInt, old);
        }
        return maxSwap;
    }

    private static List<Integer> splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        List<Integer> vals = new ArrayList<>(split.length);
        for (String s : split) {
            Integer i = Integer.valueOf(s);
            vals.add(i);
        }
        return vals;
    }
}

