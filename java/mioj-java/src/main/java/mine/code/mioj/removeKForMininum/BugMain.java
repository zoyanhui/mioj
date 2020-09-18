package mine.code.mioj.removeKForMininum;

/**
 * - 移除 K 位得到最小值
 * 序号：#9
 * 难度：困难
 * 时间限制：500ms
 * 内存限制：10M
 * 描述
 * 有一行由 N 个数字组成的数字字符串，字符串所表示的数是一正整数。移除字符串中的 K 个数字，使剩下的数字是所有可能中最小的。
 *
 * 假设：
 *
 * 字符串的长度一定大于等于 K
 * 字符串不会以 0 开头
 * 输入
 * 一行由 N 个数字组成的数字字符串（0 < N < 20），和一个正整数 K（K < N），两个数据由空格隔开，如：1432219 3。
 *
 * 输出
 * 移除 K 位后可能的最小的数字字符串。 如 1432219 移除 4, 3, 2 这 3 个数字后得到 1219，为所有可能中的最小值。
 *
 * 输入样例
 * 1432219 3
 * 10200 1
 *
 * 输出样例
 * 1219
 * 200
 *
 * Created by zhouyanhui3 on 19-10-30.
 */
import java.util.*;

public class BugMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] split = line.split(" ", 2);
            if(split.length != 2){
                System.out.println("wrong input");
                continue;
            }
            String num = split[0];
            int k = Integer.valueOf(split[1]);
            boolean[] flags = new boolean[num.length()];
            Map<Character, Integer> charPosMap = new HashMap<>(); // TODO bug: 后面相同的char会覆盖position的位置
            PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return -o1.compareTo(o2);
                }
            });
            for (int i = 0; i < num.length() && k > 0; i++) {
                char n = num.charAt(i);
                charPosMap.put(n, i);
                Character peek = maxHeap.peek();
                if(peek == null){
                    maxHeap.offer(n);
                }else if(n >= peek){
                    maxHeap.offer(n);
                }else{
                    do {
                        k--;
                        Character poll = maxHeap.poll();
                        flags[charPosMap.get(poll)] = true;
                    }while(k > 0 && maxHeap.peek() != null && maxHeap.peek() > n);
                    maxHeap.offer(n);
                }
            }
            for(;k > 0;k--){
                Character poll = maxHeap.poll();
                flags[charPosMap.get(poll)] = true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            boolean headNonZero = false;
            for (int i = 0; i < num.length(); i++) {
                if(!flags[i]){
                    char c = num.charAt(i);
                    if(!headNonZero && c == '0'){
                        continue;
                    }
                    if(c != '0'){
                        headNonZero = true;
                    }
                    stringBuilder.append(c);
                }
            }
            if(headNonZero) {
                System.out.println(stringBuilder.toString());
            }else{
                System.out.println(0);
            }
        }
    }
}

