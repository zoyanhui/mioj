package mine.code.mioj._21_CompositeMaxNumByOrder;

/**
 * - 按序组合成最大的数
 * 序号：#21
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给定两个数组，由数字 0-9 组成的，长度分别为 a 和 b，需要用 a、b 两个数组中的数字组合得到长度为 k （k <= a+b）的正整数，输出所有可能的组合中数值最大的一个（原同一数组中的数字顺序不能改变）
 *
 * 输入
 * a、b 数组中的数字间用 , 隔开，两个数组以及 k 之间用空格隔开，如：1,3,4,5,1,2 8,9,1 5，其中 a = [1,3,4,5,1,2]，b = [8,9,1]，k = 5. 数组 a, b 元素个数不大于20.
 *
 * 输出
 * 长度为 k 的所有组合中数值最大的整数，如：95121
 *
 * 从 a 或 b 中取数的时候需保证 a，b 内部的顺序不变，如第一个数取到 b 中的 9，那么 b 中只有 1 可以后续取用；第二个数取到 a 中的 5，则 a 中还剩下 1,2 可以后续取用。
 * 输入样例
 * 6,3,8,9,4,6,0 3,5,7 6
 * 2,6,8,4,3 6,9,2,5 3
 * 3,7,2 7,9,5,1 7
 *
 * 输出样例
 * 963570
 * 985
 * 7953721
 * Created by zhouyanhui on 2019/11/8.
 *
 */

import java.util.*;

public class BetterMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String answer = solution(line);
            System.out.println(answer);
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

    private static String solution(String line) {
        String[] s = line.split(" ", 3);
        if (s.length != 3) {
            return "input wrong";
        }
        int k = Integer.valueOf(s[2]);
        int[] a = splitToInts(s[0], ",");
        int[] b =splitToInts(s[1], ",");
        if(k > a.length + b.length){
            return "input wrong";
        }
        int aMinCount = Math.max(k - b.length, 0);
        int aMaxCount = Math.min(k, a.length);
        Vector<Integer> max = null;
        for (int i = aMinCount; i <= aMaxCount; i++) {
            Vector<Integer> aMax =  maxNum(a, i);
            Vector<Integer> bMax = maxNum(b, k - i);
            Vector<Integer> curMax = merge(aMax, bMax);
            if(compare(max, curMax) < 0){
                max = curMax;
            }
        }
        StringBuilder res = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < max.size(); i++) {
            if(isFirst){
                if(max.get(i) == 0){
                    continue;
                }
                isFirst = false;
            }
            res.append(max.get(i));
        }
        return res.toString();
    }

    private static int compare(Vector<Integer> a, Vector<Integer> b) {
        if(a == null){
            return b == null ? 0 : -1;
        }
        if(b == null){
            return 1;
        }
        int i = 0, j = 0;
        for (; i < a.size() && j < b.size() ; i++, j++) {
            if(a.get(i) > b.get(j)){
                return 1;
            }
            if(a.get(i) < b.get(j)){
                return -1;
            }
        }
        if(i == a.size() && j == b.size()){
            return 0;
        }
        return i == a.size() ? -1 : 1;
    }

    private static Vector<Integer> merge(Vector<Integer> aMax, Vector<Integer> bMax) {
        Vector<Integer> ret = new Vector<>();
        while(aMax.size() > 0 || bMax.size() > 0) {
            if (compare(aMax, bMax) > 0) {
                ret.add(aMax.remove(0));
            } else {
                ret.add(bMax.remove(0));
            }
        }
        return ret;
    }

    private static Vector<Integer> maxNum(int[] a, int n) {
        Stack<Integer> v = new Stack<>();
        int drop = a.length - n;
        for (int num : a) {
            while (v.size() > 0 && drop > 0 && v.peek() < num){
                v.pop();
                drop--;
            }
            v.push(num);
        }
        return new Vector<>(v.subList(0, v.size() - drop));
    }
}

