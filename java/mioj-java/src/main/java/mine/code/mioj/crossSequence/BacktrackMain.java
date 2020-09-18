package mine.code.mioj.crossSequence;

import java.util.Scanner;
import java.util.Stack;

/**
 * - 交叉队列
 * 序号：#6
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 给出三个队列 s1，s2，s3 ，判断 s3 是否是由 s1 和 s2 交叉得来。 如：s1 为 aabcc ， s2 为 dbbca。 当 s3 为 aadbbcbcac 时，返回 true（即将 s1 拆成三部分： aa，bc，c 分别插入 s2 对应位置） 否则返回 false。
 *
 * 输入
 * aabcc,dbbca,aadbbcbcac
 *
 * 输出
 * true
 *
 * 输入样例
 * aabcc,dbbca,aadbbcbcac
 * aabcc,dbbca,aadbbbaccc
 * a,b,ab
 * a,b,ba
 * a,b,ac
 * abc,bca,bcaabc
 * abc,bca,aabbcc
 *
 * 输出样例
 * true
 * false
 * true
 * true
 * false
 * true
 * false
 *
 * backtrack by stack
 * Created by zhouyanhui3 on 19-10-28.
 */
public class BacktrackMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] seqs = line.split(",", 3);
            if(seqs.length != 3 || seqs[0].length() + seqs[1].length() != seqs[2].length()){
                System.out.println(false);
                continue;
            }

            Stack<int[]> backwards = new Stack<>();
            int i = -1, j = -1;
            while(true){
                int next = i + j + 2;
                if(next == seqs[2].length() && i + 1 == seqs[0].length() && j + 1 == seqs[1].length()){
                    System.out.println(true);
                    break;
                }
                boolean firstStepOn = false;
                if(i + 1 < seqs[0].length()) {
                    if (seqs[2].charAt(next) == seqs[0].charAt(i + 1)) {
                        firstStepOn = true;
                    }
                }
                boolean secondStepOn = false;
                if(j + 1 < seqs[1].length()) {
                    if(seqs[2].charAt(next) == seqs[1].charAt(j + 1)){
                        secondStepOn = true;
                    }
                }
                if(firstStepOn){
                    if(secondStepOn){
                        backwards.push(new int[] {i, j + 1});
                    }
                    i++;
                }else if(secondStepOn){
                    j++;
                }else{
                    if(backwards.empty()){
                        System.out.println(false);
                        break;
                    }
                    int[] pop = backwards.pop();
                    i = pop[0];
                    j = pop[1];
                }

            }
        }
    }
}
