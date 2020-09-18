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
 * 超时
 */

import java.util.*;

public class BadMain {
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

    private static String solution(String line) {
        String[] s = line.split(" ", 3);
        if (s.length != 3) {
            return "input wrong";
        }
        int k = Integer.valueOf(s[2]);
        String max = findMax(s[0], s[1], 0, 0, k, true);
        return String.valueOf(max);
    }

    private static String findMax(String a, String b, int aIdx, int bIdx, int k, boolean isFirst) {
        if(k == 0){
            return "";
        }
        if(aIdx < a.length() && a.charAt(aIdx) == ','){
            aIdx++;
        }
        if(bIdx < b.length() && b.charAt(bIdx) == ','){
            bIdx++;
        }
        String v1 = null;
        if(aIdx < a.length()) {
            if(!isFirst || a.charAt(aIdx) != '0') {
                v1 = findMax(a, b, aIdx + 1, bIdx, k - 1, false);
                if (v1 == null) {
                    v1 = String.valueOf(a.charAt(aIdx));
                } else {
                    v1 = a.charAt(aIdx) + v1;
                }
            }
            String v3 = findMax(a, b, aIdx + 1, bIdx, k, isFirst ? true : false);
            v1 = maxNum(v1, v3);
        }
        String v2 = null;
        if(bIdx < b.length()) {
            if(!isFirst || b.charAt(bIdx) != '0') {
                v2 = findMax(a, b, aIdx, bIdx + 1, k - 1, false);
                if (v2 == null) {
                    v2 = String.valueOf(b.charAt(bIdx));
                } else {
                    v2 = b.charAt(bIdx) + v2;
                }
            }
            String v4 = findMax(a, b, aIdx, bIdx + 1, k, isFirst ? true : false);
            v2 = maxNum(v2, v4);
        }
        return maxNum(v1, v2);
    }

    private static String maxNum(String v1, String v2) {
        if(v1 == null){
            return v2;
        }
        if(v2 == null){
            return v1;
        }
        if(v1.length() > v2.length()){
            return v1;
        }
        if(v1.length() < v2.length()){
            return v2;
        }
        for (int j = 0; j < v1.length(); j++) {
            if(v1.charAt(j) > v2.charAt(j)){
                return v1;
            }
            if(v1.charAt(j) < v2.charAt(j)){
                return v2;
            }
        }
        return v1;
    }
}

