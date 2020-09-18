package mine.code.mioj.longestNumSequence;

/**
 * - 最长连续数列
 * 序号：#4
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 输入一个乱序的连续数列，输出其中最长连续数列长度，要求算法复杂度为 O(n) 。
 *
 * 输入
 * 54,55,300,12,56
 *
 * 输出
 * 3
 *
 * 输入样例
 * 100,4,200,1,3,2
 * 54,55,300,12
 * 1
 * 5,4,3,2,1
 * 1,2,3,4,5,6
 *
 * 输出样例
 * 4
 * 2
 * 1
 * 5
 * 6
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
        Map<Integer, Integer> lenOfNumSeq = new HashMap<>();
        int max = 0;
        for (Integer anInt : ints) {
            Integer len = lenOfNumSeq.get(anInt);
            if (len != null) {
                continue;
            }
            Integer before = lenOfNumSeq.get(anInt - 1);
            Integer after = lenOfNumSeq.get(anInt + 1);
            Integer newLen = 0;
            if (before == null && after == null) {
                newLen = 1;
                lenOfNumSeq.put(anInt, newLen);
            } else {
                if (before != null && after == null) {
                    newLen = before + 1;
                    lenOfNumSeq.put(anInt, newLen);
                    lenOfNumSeq.put(anInt - before, newLen);
                } else if (before == null && after != null) {
                    newLen = after + 1;
                    lenOfNumSeq.put(anInt, newLen);
                    lenOfNumSeq.put(anInt + after, newLen);
                } else {
                    newLen = before + after + 1;
                    lenOfNumSeq.put(anInt, newLen);
                    lenOfNumSeq.put(anInt - before, newLen);
                    lenOfNumSeq.put(anInt + after, newLen);
                }
            }
            max = max > newLen ? max : newLen;
        }
        return max;
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

