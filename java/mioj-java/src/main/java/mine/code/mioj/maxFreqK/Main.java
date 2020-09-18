package mine.code.mioj.maxFreqK;

/**
 * - 出现频率最高的前 K 个元素
 * 序号：#13
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 有一个不为空且仅包含正整数的数组，找出其中出现频率最高的前 K 个数，时间复杂度必须在 O(n log n) 以内。
 *
 * 输入
 * 一行数据包括两部分，一个正整数数组（数字间 ',' 分隔）和一个正整数 K （1 ≤ K ≤ 数组长度），数组和 K 之间有一个空格。
 *
 * 输出
 * 输出包含前 K 个出现频率最高的数（出现频率相同时，较小的数在前），用 ', ' 分隔，保证升序排列。
 *
 * 输入样例
 * 1,1,1,2,2,3 2
 *
 * 输出样例
 * 1,2
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
            List<Integer> answer = solution(line);
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : answer) {
                stringBuilder.append(integer);
                stringBuilder.append(",");
            }
            System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
        }
    }

    private static List<Integer> solution(String line) {
        String[] s = line.split(" ", 2);
        int k = Integer.valueOf(s[1]);
        List<Integer> ints = splitToInts(s[0], ",");
        Map<Integer, Integer> intFreqs = new HashMap<>();
        for (Integer anInt : ints) {
            Integer freq = intFreqs.get(anInt);
            if (freq == null) {
                intFreqs.put(anInt, 1);
            } else {
                intFreqs.put(anInt, freq + 1);
            }
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int compare = Integer.compare(intFreqs.get(o1), intFreqs.get(o2));
                if (compare != 0) {
                    return compare;
                }
                return -Integer.compare(o1, o2);
            }
        };
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(comparator);
        for (Integer aInt : intFreqs.keySet()) {
            pushHeap(aInt, minHeap, k, comparator);
        }
        List<Integer> ret = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ret.add(minHeap.poll());
        }
        Collections.reverse(ret);
        return ret;
    }

    private static void pushHeap(Integer anInt, PriorityQueue<Integer> minHeap, int k, Comparator<Integer> comparator) {
        if (minHeap.size() < k) {
            minHeap.offer(anInt);
            return;
        }
        if (comparator.compare(anInt, minHeap.peek()) <= 0) {
            return;
        }
        minHeap.poll();
        minHeap.offer(anInt);
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

