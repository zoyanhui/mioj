package mine.code.mioj._40_FindLittleThree;

/**
 * - 找小“3”
 * 序号：#40
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给定一个奇数n，可得到一个由从1到n的所有奇数所组成的数列，求这一数列中数字3所出现的总次数。例如当n=3时，可得到奇数列：1,3，其中有一个数字3，故可得1
 *
 * 输入
 * 一个奇数。表示n，0<n<9999999999。
 *
 * 输出
 * 一个整数，表示从 1 到 n 的奇数列中，数字 3 出现的次数。
 *
 * 输入样例
 * 1
 * 3
 * 35
 * 23
 * 30
 * 40
 * 99
 *
 * 输出样例
 * 0
 * 1
 * 7
 * 3
 * 3
 * 15
 *
 * Created by zhouyanhui on 2019/11/17.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            long answer = solution(line);
            System.out.println(answer);
        }
    }

    private static long solution(String line) {
        int decimals = line.length();
        int[] nums = new int[decimals];
        for (int i = 0; i < decimals; i++) {
            nums[i] = line.charAt(i) - '0';
        }
        long total = 0;
        for (int i = 0; i < decimals; i++) {
            total += calNums(nums, i);
        }
        return total;
    }

    private static long calNums(int[] nums, int i) {
        long count = 0;
        if(nums[i] >3){
            for (int j = 0; j < i; j++) {
                count += nums[j] * Math.pow(10, nums.length - j - 2);
            }
            count += Math.pow(10, nums.length - i - 1) - 1;
            if(i == nums.length - 1){
                count += 1;
                return count;
            }
            long res = count / 2;
            if((count & 0x1) == 1){
                res+=1;
            }
            return res;
        }else if(nums[i] < 3){
            if(i == 0){
                return 0;
            }
            for (int j = 0; j < i; j++) {
                count += nums[j] * Math.pow(10, nums.length - j - 2);
            }
            count -= 1;
            long res = 0;
            if(i != nums.length - 1){
                res = count / 2;
                if((count & 0x1) == 1){
                    res+=1;
                }
            }else{
                 res = count + 1;
            }
            return res;
        }else{
            for (int j = 0; j < i; j++) {
                count += nums[j] * Math.pow(10, nums.length - j - 2);
            }
            for (int j = i+1; j < nums.length; j++) {
                count += nums[j] * Math.pow(10, nums.length - j - 1);
            }
            if(i == nums.length - 1){
                count += 1;
                return count;
            }
            long res = count / 2;
            if((count & 0x1) == 1){
                res+=1;
            }
            return res;
        }
    }
}

