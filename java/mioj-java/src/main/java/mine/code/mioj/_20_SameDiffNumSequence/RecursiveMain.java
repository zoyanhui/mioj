package mine.code.mioj._20_SameDiffNumSequence;

/**
 * - 有多少个等差数列？
 * 序号：#20
 * 难度：困难
 * 时间限制：500ms
 * 内存限制：10M
 * 描述
 * 等差数列是常见数列的一种，如果一个数列从第二项起，每一项与它的前一项的差等于同一个常数，这个数列就叫做等差数列，而这个常数叫做等差数列的公差，公差常用字母d表示。即对于数列S，它满足了(S[i]-S[i-1]) = d (i \gt 1)(S[i]−S[i−1])=d(i>1)。 显然，一个数字无法构成等差数列，而任意两个数字可以形成一个等差数列。 这里给出了一个长度为N (0 \lt N \lt 200)N(0<N<200)的数字序列，每个位置有一个整数(-100 \le \text{整数} \le 100)(−100≤整数≤100)，需要找到这个数字序列里包含多少个等差数列，序列顺序固定，无需排序。 输入数据格式：\text{S[0] S[1] S[2] ... S[N]}S[0] S[1] S[2] ... S[N]（以半角空格符分隔，N \gt 1N>1） 输出数据格式：等差数列数量 MM； 其中数列 SS 的项为整数
 *
 * 请注意时间复杂度的限制。
 *
 * 输入
 * 输入一个数列[ 2 7 4 5 6 ]，该数列包含等差数列： [ 2 7 ] [ 2 4 ] [ 2 5 ] [ 2 6 ] [ 7 4 ] [ 7 5 ] [ 7 6 ] [ 4 5 ] [ 4 6 ] [ 5 6 ] [ 2 4 6 ] [ 4 5 6 ]
 *
 * 输出
 * 上例共包含12组等差数列，故应输出12
 *
 * 输入样例
 * 2 7 4 5 6
 * 3 3 3 3
 *
 * 输出样例
 * 12
 * 11
 * Created by zhouyanhui on 2019/11/7.
 */

import java.util.Scanner;

public class RecursiveMain {
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
        int[] s = splitToInts(line, " ");
        if(s.length < 2){
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                ret += calc(j, s[j] - s[i], s);
            }
        }
        return ret;
    }

    private static int calc(int curIdx, int delta, int[] nums) {
        if(curIdx >= nums.length){
            return 0;
        }
        int ret = 1;
        for (int i = curIdx + 1; i < nums.length; i++) {
            if(nums[i] == nums[curIdx] + delta){
                ret += calc(i, delta, nums);
            }
        }
        return ret;
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

