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
 * 第 1 个整数为整数 KK，1 \le K \le 10^61≤K≤10
 * 6
 *  ；
 *
 * 第 2 个为整数 nn，表示数字的数量，n \lt 10^7n<10
 * 7
 *  ；
 *
 * 接下来有 nn 个整数，每个数的大小不超过 10^610
 * 6
 *  .
 *
 * 输出
 * 输出排序之后的第 KK 位置的数值。
 *
 * 输入样例
 * 4 6 1 2 3 4 5 6
 *
 * 输出样例
 * 5
 *
 *
 * BAD: 运行超时
 * Created by zhouyanhui on 2019/12/6.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BadMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
        }
    }

    static int solution(String line) {
        String[] s = line.split(" ");
        int K = Integer.valueOf(s[0]);
        int n = Integer.valueOf(s[1]);
        Integer[] nums = new Integer[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(s[2+i]);
            max = Math.max(max, Math.abs(nums[i]));
        }
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 2; i <= max; i++) {
            if(isPrime(i)){
                primes.add(i);
            }
        }
//            System.out.println(Arrays.toString(primes.toArray(new Integer[0])));
        Map<Integer, Integer> divisors = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(divisors.containsKey(nums[i])){
                continue;
            }
            divisors.put(nums[i], calcDivisors(Math.abs(nums[i]), primes));
        }
//            System.out.println(divisors);
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int compare = Integer.compare(divisors.get(o1), divisors.get(o2));
                if(compare == 0){
                    return Integer.compare(o1, o2);
                }
                return compare;
            }
        });
//            System.out.println(Arrays.toString(nums));
        return nums[K-1];
    }

    private static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    private static int calcDivisors(int num, List<Integer> primes) {
        int sum = 1;
        loop:
        while(num > 0){
            for (int i = 0; i < primes.size(); i++) {
                int c = primes.get(i);
                if(num < c){
                    break loop;
                }
                int count = 0;
                while(num > 1 && num % c == 0){
                    num /= c;
                    count ++;
                }
                sum *= (count + 1);
            }
        }
        return sum;
    }
}

