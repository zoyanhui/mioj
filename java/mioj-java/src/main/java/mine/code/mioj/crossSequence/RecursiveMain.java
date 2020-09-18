package mine.code.mioj.crossSequence;

import java.util.*;

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
 * recursive solution
 *
 * Created by zhouyanhui3 on 19-10-28.
 */
public class RecursiveMain {
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
            if(checkCross(seqs[0], 0, seqs[1], 0, seqs[2], 0)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }

            // System.out.println("answer");
        }
    }

    private static boolean checkCross(String a, int ai, String b, int bi, String ab, int i){
        if(i == ab.length()){
            if(ai == a.length() && bi == b.length()){
                return true;
            }
            return false;
        }
        if(ai < a.length()){
            if(ab.charAt(i) == a.charAt(ai)){
                if(checkCross(a, ai + 1, b, bi, ab, i + 1)){
                    return true;
                }
            }
        }
        if(bi < b.length()){
            if(ab.charAt(i) == b.charAt(bi)){
                if(checkCross(a, ai, b, bi + 1, ab, i + 1)){
                    return true;
                }
            }
        }
        return false;
    }
}
