package mine.code.mioj._143_MituBathing;

/**
 * - 小米兔洗澡澡
 * 序号：#143
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：64M
 * 描述
 * 小米兔每天都要去公共浴室洗澡，但是有时候公共浴室人太多，需要排队，小米兔想知道它什么时候能洗澡，你可以帮他算算他要多久才能洗完澡吗？
 *
 * 公共浴室最多可同时容纳 n 个人洗澡，每个人洗澡的时间为k分钟，多余的人只能在外面排队等候。（ps：保证不会有插队现象出现）
 *
 * 小米兔在第a时刻准备好去公共浴室洗澡，问小米兔什么时候才能洗完澡(初始状态：公共浴室为空）。
 *
 * 注意：如果有和小米兔同一时刻去公共浴室的。小米兔排到该时刻全部人的后面。（因为小米兔会礼让）
 *
 * 输入
 * 第一行三个整数n， k， q（1≤ n ≤100,1≤ k ≤50,1≤ q ≤ 1e5）
 *
 * 第二行q组整数(每组两个整数x，y代表在x时刻有y人去澡堂洗澡，1≤ x ≤1e5,1≤ y ≤100 ）
 *
 * 第三行一个整数a（a含义如上）
 *
 * 输出
 * 输出小米兔洗完澡的时刻，每组输出占一行。
 *
 * 输入样例
 * 2 5 3
 * 1 1 2 1 3 1
 * 4
 *
 * 21 9 10
 * 6501 70 6526 79 6585 63 6650 6 6696 82 6724 62 6816 96 6859 28 6896 92 6901 3
 * 6655
 *
 * 输出样例
 * 12
 * 6664
 *
 * Created by zhouyanhui on 2019/12/8.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().trim();
        String[] s = line.split(" ", 3);
        int n = Integer.valueOf(s[0]);
        int k = Integer.valueOf(s[1]);
        int q = Integer.valueOf(s[2]);
        line = scan.nextLine().trim();
        int[] ints = splitToInts(line, " ");
        line = scan.nextLine().trim();
        int a = Integer.valueOf(line);
        System.out.println(solution(n,k,q,a,ints));
    }

    static int solution(int n, int k, int q, int a, int[] ints) {
        int[] count = new int[100000+1];
        for (int i = 0; i < q; i++) {
            int time = ints[2*i];
            if(time > a){
                continue;
            }
            int persons = ints[2*i+1];
            count[time] += persons;
        }
        int[][] personsAtTime = new int[2][51];
        int adx = 0, idx=-1;
        int persons = 0, lastK = 0;
        for (int i = 1; ; i++) {
            persons += i< count.length ? count[i] : 0;
            idx++;
            if(idx == 51){
                idx = 0;
                lastK -= personsAtTime[adx][51-k];
                adx = (adx + 1) % 2;
            }else{
                if(idx-k >= 0){
                    lastK -= personsAtTime[adx][idx-k];
                }else{
                    lastK -= personsAtTime[(adx+1)%2][50-(k-idx) + 1];
                }
            }
            if(n > lastK){
                personsAtTime[adx][idx] = n - lastK;
                if(persons < personsAtTime[adx][idx]){
                    personsAtTime[adx][idx] = persons;
                    if(i >= a){
//                        System.out.println(Arrays.toString(personsAtTime[0]));
//                        System.out.println(Arrays.toString(personsAtTime[1]));
//                        System.out.println("idx:"+idx + " adx:" + adx + " i:" + i);
                        return i+k;
                    }
                }
                persons -= personsAtTime[adx][idx];
                lastK += personsAtTime[adx][idx];
            }else{
                personsAtTime[adx][idx] = 0;
            }
        }
    }

    static int[] splitToInts(String line, String sep) {
        String[] split = line.split(sep);
        int[] ret = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ret[i] = Integer.valueOf(split[i]);
        }
        return ret;
    }
}

