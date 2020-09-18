package mine.code.mioj.midOfRotateSequence;

import java.util.*;

/**
 * - 找出旋转有序数列的中间值
 * 序号：#5
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出一个有序数列随机旋转之后的数列，如原有序数列为：[0,1,2,4,5,6,7] ，旋转之后为[4,5,6,7,0,1,2]。 假定数列中无重复元素，且数列长度为奇数。 求出旋转数列的中间值。如数列[4,5,6,7,0,1,2]的中间值为4。
 *
 * 输入
 * 4,5,6,7,0,1,2
 *
 * 输出
 * 4
 *
 * 输入样例
 * 1
 * 1,2,3
 * 4,5,6,7,0,1,2
 * 12,13,14,5,6,7,8,9,10
 * 输出样例
 * 1
 * 2
 * 4
 * 9
 *
 * Created by zhouyanhui3 on 19-10-25.
 */
public class Main {
    private static Comparator<String> numComparator = new Comparator<String>() {
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()){
                for (int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i) < o2.charAt(i)){
                        return -1;
                    }else if(o1.charAt(i) > o2.charAt(i)){
                        return 1;
                    }
                }
                return 0;
            }
            return Integer.compare(o1.length(), o2.length());
        }
    };

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] nums = line.split(",");
            // please write your code here
            int len = nums.length;
            if (len % 2 == 0) {
                System.out.println("wrong input");
                continue;
            }
            if (len == 1) {
                System.out.println(line);
                continue;
            }

            int check1 = numComparator.compare(nums[0], nums[1]);
            int check2 = numComparator.compare(nums[len-2], nums[len-1]);
            int check3 = numComparator.compare(nums[len-1], nums[0]);
            boolean asc = check1 + check2 + check3 > 0 ? false : true;
            int i = 1;
            for (; i < len; i++) {
                if (asc) {
                    if (numComparator.compare(nums[i-1], nums[i]) > 0) {
                        break;
                    }
                } else {
                    if (numComparator.compare(nums[i-1], nums[i]) < 0) {
                        break;
                    }
                }
            }
            if (i > len / 2) {
                System.out.println(nums[i - len / 2 - 1]);
                continue;
            } else {
                System.out.println(nums[i + len / 2]);
                continue;
            }
        }
    }
}
