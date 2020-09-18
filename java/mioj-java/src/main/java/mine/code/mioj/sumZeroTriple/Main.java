package mine.code.mioj.sumZeroTriple;

/**
 * - 和为零的三元组
 * 序号：#15
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个整数数组, 数组中是否存在任意 3 个数 a, b, c 满足 a + b + c = 0? 找出数组中所有满足以上条件的三元组，最后输出这些三元组的个数（包含相同元素的三元组只计算一次）。
 *
 * 输入
 * 一个包含多个整数（正或负）的字符串，每个整数之间用逗号（,）分隔，如：-1,0,1,2,-1,-4。
 *
 * 输出
 * 输入满足加和结果正好等于 0 的三元组的个数，如对于 -1,0,1,2,-1,-4 有 [-1, 0, 1] 和 [-1, -1, 2]，所以输出 2
 *
 * 输入样例
 * -1,0,1,2,-1,-4
 *
 * 输出样例
 * 2
 * Created by zhouyanhui on 2019/11/5.
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
        if(ints.size() < 3){
            return 0;
        }
        Collections.sort(ints);
        int total = 0;
        for (int i = 0; i < ints.size()-2; i++) {
            if(i > 0 && ints.get(i).equals(ints.get(i - 1))){
                continue;
            }
            int pivot = -ints.get(i);
            int m=i+1,n=ints.size()-1;
            while(m < n){
                int sum = ints.get(m) + ints.get(n);
                if(sum > pivot){
                    do{
                        n--;
                    }while(m < n && ints.get(n).equals(ints.get(n + 1)));
                }else if(sum < pivot){
                    do{
                        m++;
                    }while(m < n && ints.get(m).equals(ints.get(m - 1)));
                }else{
                    total++;
                    n--;
                    m++;
                    while(m < n && ints.get(n).equals(ints.get(n+1))) {
                        n--;
                    }
                    while(m < n && ints.get(m).equals(ints.get(m - 1))){
                        m++;
                    }
                }
            }
        }
        return total;
    }

    private static List<Integer> splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            ret.add(Integer.valueOf(split[i]));
        }
        return ret;
    }
}

