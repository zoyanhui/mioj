package mine.code.mioj.firstMissPositiveNum;

/**
 * 第一个缺失正数
 * 序号：#7
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个无序的数列，找出其中缺失的第一个正数，要求复杂度为 O(n) 如：[1,2,0]，第一个缺失为3。 如：[3,4,-1,1]，第一个缺失为2。
 *
 * 输入
 * 1,2,0
 *
 * 输出
 * 3
 *
 * 输入样例
 * 1,2,0
 * 3,4,-1,1
 * -1,-3,-5
 * 1,2,3
 * -1,-10,0
 *
 * 输出样例
 * 3
 * 2
 * 1
 * 4
 * 1
 *
 * Created by zhouyanhui3 on 19-10-29.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] nums = line.split(",");
            boolean[] rnums = new boolean[nums.length + 1];
            for (String num : nums) {
                char c = num.charAt(0);
                if(c == '-' || c == '0'){
                    continue;
                }
                int n = Integer.valueOf(num);
                if(n >= rnums.length){
                    continue;
                }
                rnums[n] = true;
            }
            boolean miss = false;
            for (int i = 1; i < rnums.length; i++) {
                if(!rnums[i]){
                    miss = true;
                    System.out.println(i);
                    break;
                }
            }
            if(!miss){
                System.out.println(rnums.length);
            }
        }
    }
}