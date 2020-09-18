package mine.code.mioj.removeKForMininum;

/**
 * - 移除 K 位得到最小值
 * 序号：#9
 * 难度：困难
 * 时间限制：500ms
 * 内存限制：10M
 * 描述
 * 有一行由 N 个数字组成的数字字符串，字符串所表示的数是一正整数。移除字符串中的 K 个数字，使剩下的数字是所有可能中最小的。
 *
 * 假设：
 *
 * 字符串的长度一定大于等于 K
 * 字符串不会以 0 开头
 * 输入
 * 一行由 N 个数字组成的数字字符串（0 < N < 20），和一个正整数 K（K < N），两个数据由空格隔开，如：1432219 3。
 *
 * 输出
 * 移除 K 位后可能的最小的数字字符串。 如 1432219 移除 4, 3, 2 这 3 个数字后得到 1219，为所有可能中的最小值。
 *
 * 输入样例
 * 1432219 3
 * 10200 1
 *
 * 输出样例
 * 1219
 * 200
 *
 * Created by zhouyanhui3 on 19-10-30.
 */

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] split = line.split(" ", 2);
            if (split.length != 2) {
                System.out.println("wrong input");
                continue;
            }
            String num = split[0];
            int k = Integer.valueOf(split[1]);
            int N = num.length();
            boolean[] flags = new boolean[N];
            char[] chars = new char[N];
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Character.compare(chars[o1], chars[o2]);
                }
            });
            for (int i = 0; i < N && k > 0; i++) {
                char n = num.charAt(i);
                chars[i] = n;
                Integer peek = maxHeap.peek();
                if (peek == null) {
                    maxHeap.offer(i);
                } else if (n >= chars[peek]) {
                    maxHeap.offer(i);
                } else {
                    do {
                        k--;
                        int poll = maxHeap.poll();
                        flags[poll] = true;
                    } while (k > 0 && maxHeap.peek() != null && chars[maxHeap.peek()] > n);
                    maxHeap.offer(i);
                }
            }
            for (; k > 0; k--) {
                int poll = maxHeap.poll();
                flags[poll] = true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            boolean headNonZero = false;
            for (int i = 0; i < N; i++) {
                if (!flags[i]) {
                    char c = num.charAt(i);
                    if (!headNonZero && c == '0') {
                        continue;
                    }
                    if (c != '0') {
                        headNonZero = true;
                    }
                    stringBuilder.append(c);
                }
            }
            if (headNonZero) {
                System.out.println(stringBuilder.toString());
            } else {
                System.out.println(0);
            }
        }
    }
}

