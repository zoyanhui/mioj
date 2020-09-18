package mine.code.mioj._72_SimpleAllPermutation;

/**
 * - 简单直接全排列
 * 序号：#72
 * 难度：困难
 * 时间限制：2000ms
 * 内存限制：15M
 * 描述
 * 给一个无重复数字的整数列，输出这些整数的全排列，按升序排列所有组合。
 *
 * 输入
 * 一组数字，用英文逗号隔开，如：1,2,3
 *
 * 输出
 * 输出由这组数字能组成的所有组合，按升序排列，使用英文逗号(,)隔开每个数字，使用英文分号(;)隔开所有组合，如：1,2,3;1,3,2;2,1,3;2,3,1;3,1,2;3,2,1
 *
 * 输入样例
 * 1,2,3
 *
 * 输出样例
 * 1,2,3;1,3,2;2,1,3;2,3,1;3,1,2;3,2,1
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
            String answer = solution(ints);
            System.out.println(answer);
        }
    }

    private static String solution(int[] ints) {
        Arrays.sort(ints);
        List<String> permutations = new ArrayList<>();
        permutate(ints, 0, new Stack<>(), permutations);
        return String.join(";", permutations);
    }

    private static void permutate(int[] ints, int idx, Stack<String> stack, List<String> permutations) {
        if(idx == ints.length){
            permutations.add(String.join(",", stack));
            return;
        }
        for (int i = idx; i < ints.length; i++) {
            int temp = ints[i];
            int j = i;
            while(j > idx){
                ints[j] = ints[j - 1];
                j--;
            }
            ints[idx] = temp;
            stack.add(String.valueOf(ints[idx]));
            permutate(ints, idx + 1, stack, permutations);
            stack.pop();

            temp = ints[idx];
            j = idx;
            while(j<i){
                ints[j] = ints[j+1];
                j++;
            }
            ints[i] = temp;
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
