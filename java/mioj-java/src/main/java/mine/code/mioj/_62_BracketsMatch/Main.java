package mine.code.mioj._62_BracketsMatch;

/**
 * - 括号配对
 * 序号：#62
 * 难度：一般
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 我们知道，在逻辑表达式中广泛使用了括号，而括号都是层次化成对出现的。也就是任意左括号都应该存在一个在同一逻辑层级的右括号作为对应。 现在我们有一些仅由括号组成的字符串序列，保证每个字符为大括号”{”,”}”、中括号”[”,”]”和小括号”(”,”)”中的一种。 需要判断给定的的序列是否合法。
 *
 * 输入
 * 一行仅由括号组成的字符串
 *
 * 输出
 * 如果序列合法输出 1，否则输出 0
 *
 * 输入样例
 * [()]
 * ({[])}
 * [()]{}
 *
 * 输出样例
 * 1
 * 0
 * 1
 *
 * Created by zhouyanhui on 2019/11/23.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            int answer = solution(line);
            System.out.println(answer);
        }
    }

    private static int solution(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return 0;
                }
                if(c == ')' && stack.pop() != '('){
                    return 0;
                }else if(c == ']' && stack.pop() != '['){
                    return 0;
                }else if(c == '}' && stack.pop() != '{'){
                    return 0;
                }
            }
        }
        return 1;
    }
}

