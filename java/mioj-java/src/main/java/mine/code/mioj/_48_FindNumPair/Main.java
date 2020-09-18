package mine.code.mioj._48_FindNumPair;

/**
 * - 找数字对
 * 序号：#48
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 有一串可能含重复数字的列表，例如 N = {4,13,5,6,35,85,3}，对于任意 A ∈ N，B ∈ N, 使 A+B = 10 或 |A-B| = 10； 即两数之合为 10 或两数之差的绝对值为 10。
 *
 * 找出所有满足条件的数字对 {A,B} 的个数。(A, B的顺序与原始数组保持一致)
 *
 * 输入
 * 一行文本由英文逗号分隔，如 6,4,16
 *
 * 输出
 * 2
 *
 * 输入样例
 * 4,13,5,6,35,85,3
 * 13,3,6,8,12,4,45,56,66,16
 * 6,4,16
 *
 * 输出样例
 * 2
 * 4
 * 2
 * Created by zhouyanhui3 on 19-11-19.
 */
import java.util.*;

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
        int[] ints = splitToInts(line, ",");
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int anInt : ints) {
            Integer old = countMap.getOrDefault(anInt, 0);
            countMap.put(anInt, old + 1);
        }
        Set<Integer> marked = new HashSet<>();
        int total = 0;
        for (Integer anInt : countMap.keySet()) {
            Integer count = countMap.get(anInt);
            marked.add(anInt);
            if(anInt == 5){
                total += count * (count - 1) / 2;
                if(!marked.contains(15)) {
                    total += count * (countMap.getOrDefault(15, 0));
                }
                if(!marked.contains(-5)) {
                    total += count * (countMap.getOrDefault(-5, 0));
                }
            }else{
                if(!marked.contains(10 - anInt)) {
                    total += count * (countMap.getOrDefault(10 - anInt, 0));
                }
                if(anInt != 10 && !marked.contains(anInt - 10)) {
                    total += count * (countMap.getOrDefault(anInt - 10, 0));
                }
                if(anInt != 0 && !marked.contains(anInt + 10)) {
                    total += count * (countMap.getOrDefault(anInt + 10, 0));
                }
            }
        }
        return total;
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

