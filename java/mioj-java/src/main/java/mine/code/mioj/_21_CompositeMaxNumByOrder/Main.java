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

import java.util.Scanner;

public class Main {
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
        String max = findMax(a, b, 0, 0, k, true);
        int notZeroIdx = 0;
        for (; notZeroIdx < max.length(); notZeroIdx++) {
            if(max.charAt(notZeroIdx) != '0'){
                break;
            }
        }
        return max.substring(notZeroIdx);
    }

    private static String findMax(int[] a, int[] b, int aIdx, int bIdx, int k, boolean isFirst) {
        if(k == 0){
            return "";
        }
        int remove = a.length - aIdx + b.length - bIdx - k;
        int aMaxIdx = -1;
        if(aIdx < a.length){
            aMaxIdx = findStepMaxIdx(a, aIdx, remove);
        }
        int bMaxIdx = -1;
        if(bIdx < b.length){
            bMaxIdx = findStepMaxIdx(b, bIdx, remove);
        }
        if(aMaxIdx >= 0) {
            if (bMaxIdx < 0 || a[aMaxIdx] > b[bMaxIdx]) {
                return a[aMaxIdx] + findMax(a, b, aMaxIdx + 1, bIdx, k - 1, false);
            }else if(a[aMaxIdx] < b[bMaxIdx]){
                return b[bMaxIdx] + findMax(a, b, aIdx, bMaxIdx + 1, k - 1, false);
            }else{
                String v1 = findMax(a, b, aMaxIdx + 1, bIdx, k - 1, false);
                String v2 = findMax(a, b, aIdx, bMaxIdx + 1, k - 1, false);
                return a[aMaxIdx] + maxNum(v1, v2);
            }
        }else{
            if(bMaxIdx < 0){
                return "";
            }
            return b[bMaxIdx] + findMax(a, b, aIdx, bMaxIdx + 1, k - 1, false);
        }
    }

    private static int findStepMaxIdx(int[] a, int aIdx, int remove) {
        int aMaxIdx = aIdx;
        for (int i = aIdx + 1; i <= aIdx + remove && i < a.length; i++) {
            if(a[i] > a[aMaxIdx]){
                aMaxIdx = i;
            }
        }
        return aMaxIdx;
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

