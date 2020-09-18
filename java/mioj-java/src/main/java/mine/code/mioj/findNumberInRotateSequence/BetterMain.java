package mine.code.mioj.findNumberInRotateSequence;

/**
 * - 在一个有序的经过旋转的数组里查找一个数
 * 序号：#14
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 假设一个有序的数组，经过未知次数的旋转（例如0 1 2 4 5 6 7 被旋转成 4 5 6 7 0 1 2），从中查找一个目标值，如果存在，返回其下标，不存在，返回-1。注：假设数组无重复数字
 *
 * 输入
 * 输入一个有序经过旋转的数组和要查找的目标数字，数组中各数字用“逗号”分隔，数组和目标数字用“空格”分隔
 *
 * 输出
 * 一个整数，表示该目标数字的下标（不存在返回-1）
 *
 * 输入样例
 * 4,5,6,7,0,1,2 6
 *
 * 输出样例
 * 2
 * Created by zhouyanhui3 on 19-11-5.
 */

import java.util.Scanner;

public class BetterMain {
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
        String[] split = line.split(" ", 2);
        int n = Integer.valueOf(split[1]);
        int[] ints = splitToInts(split[0], ",");
        int mid = (ints.length) / 2;
        int c = Integer.compare(ints[0], ints[mid]) + Integer.compare(ints[mid], ints[ints.length -1]) + Integer.compare(ints[ints.length - 1], ints[0]);
        boolean isAsc = c < 0;
        return search(ints, 0, ints.length - 1, n, isAsc);
    }

    private static int search(int[] ints, int start, int end, int n, boolean isAsc) {
        if(end < start){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(n == ints[mid]){
            return mid;
        }
        if(isAsc) {
            if(ints[mid] > ints[end] && ints[mid] >= ints[start]){
                // biggest in [mid, end]
                if(n > ints[mid]){
                    return search(ints, mid + 1, end, n, isAsc);
                }else if(n >= ints[start]){
                    return search(ints, start, mid - 1, n, isAsc);
                }else {
                    return search(ints, mid + 1, end, n, isAsc);
                }
            }else if(ints[mid] < ints[end] && ints[mid] <= ints[start]){
                // biggest in [start, mid]
                if(n < ints[mid]){
                    return search(ints, start, mid - 1, n, isAsc);
                }else if(n >= ints[start]){
                    return search(ints, start, mid - 1, n, isAsc);
                }else {
                    return search(ints, mid + 1, end, n, isAsc);
                }
            }else if(ints[mid] < ints[end] && ints[mid] >= ints[start]){
                // biggest is end
                if(n < ints[mid]){
                    return search(ints, start, mid - 1, n, isAsc);
                }else {
                    return search(ints, mid + 1, end, n, isAsc);
                }
            }else{
                // not exists
                return -1;
            }
        }else{
            if(ints[mid] > ints[end] && ints[mid] >= ints[start]){
                // biggest in [start, mid]
                if(n > ints[mid]){
                    return search(ints, start, mid -1, n, isAsc);
                }else if(n <= ints[start]){
                    return search(ints, start, mid - 1, n, isAsc);
                }else {
                    return search(ints, mid + 1, end, n, isAsc);
                }
            }else if(ints[mid] < ints[end] && ints[mid] <= ints[start]){
                // biggest in [mid, end]
                if(n < ints[mid]){
                    return search(ints, mid + 1, end, n, isAsc);
                }else if(n <= ints[start]){
                    return search(ints, start, mid - 1, n, isAsc);
                }else {
                    return search(ints, mid + 1, end, n, isAsc);
                }
            }else if(ints[mid] > ints[end] && ints[mid] <= ints[start]){
                // biggest is end
                if(n > ints[mid]){
                    return search(ints, start, mid - 1, n, isAsc);
                }else {
                    return search(ints, mid + 1, end, n, isAsc);
                }
            }else{
                // not exists
                return -1;
            }
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
