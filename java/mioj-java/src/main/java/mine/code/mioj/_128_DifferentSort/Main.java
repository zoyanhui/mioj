package mine.code.mioj._128_DifferentSort;

/**
 * - 不一样的排序
 * 序号：#128
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：32M
 * 描述
 * 有一天利姆鲁想教他的哥布林部下学数学，因为他之前教过因子，现在想考考他们。
 *
 * 利姆鲁问现在有 nn 个数，需要用因子个数的多少进行排序，因子个数多的排在后面，因子个数少的排在前面，如果因子个数相同那么就比较这个数的大小，数大的放在后面，数小的放在前面。现在让你说出排序之后第 KK 个位置的数字是多少。
 *
 * 输入
 * 第 1 个整数为整数 K，1 ≤K≤10^6
 * 6
 *  ；
 *
 * 第 2 个为整数 n，表示数字的数量，n<10^7
 * 7
 *  ；
 *
 * 接下来有 n 个整数，每个数的大小不超过 10^6
 * 6
 *  .
 *
 * 输出
 * 输出排序之后的第 K 位置的数值。
 *
 * 输入样例
 * 4 6 1 2 3 4 5 6
 *
 * 输出样例
 * 5
 *
 *
 * 运行超时。 比较奇怪？
 * Created by zhouyanhui on 2019/12/6.
 */

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            long start = System.currentTimeMillis();
            System.out.println(solution(line));
            System.out.println("cost:" + (System.currentTimeMillis() - start));
        }
    }

    static int solution(final String line) {
        String[] s = line.split(" ");
        int K = Integer.valueOf(s[0]);
        int n = Integer.valueOf(s[1]);
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(s[2+i]);
            max = Math.max(max, nums[i]);
        }
        int[] divisors = new int[max+1];
        for (int i = 1; i <= Math.sqrt(max+1); i++) {
            divisors[i*i]++;
            for (int j = i+1; j <=max; j++) {
                int ma = i * j;
                if(ma <= max) {
                    divisors[ma] += 2;
                }else{
                    break;
                }
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[divisors[nums[i]]]++;
        }
        int k = K, i = 0;
        for (; i < count.length; i++) {
            if(k < count[i]){
                break;
            }
            k-=count[i];
        }
        if(k == 0){
            i--;
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(divisors[nums[j]] == i){
                list.add(nums[j]);
            }
        }
        Collections.sort(list);
        if(k == 0){
            return list.get(list.size() - 1);
        }else{
            return list.get(k - 1);
        }
    }
}

