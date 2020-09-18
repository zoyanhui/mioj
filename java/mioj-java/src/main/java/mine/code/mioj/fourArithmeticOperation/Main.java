package mine.code.mioj.fourArithmeticOperation;

/**
 * - 四则运算
 * 序号：#16
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 实现一个算法，可以进行任意非负整数的加减乘除组合四则运算。
 *
 * 请注意运算符的优先级。
 *
 * 输入
 * 请输入一行算式，使用空格分隔数字与运算符。
 *
 * 数字为任意非负整数，运算符为+ - * /，不考虑括号。
 *
 * 输出
 * 输出算式的运算结果。如果是小数，请向下取整（包含中间步骤结果）。 如果出现“除0异常”，输出err。
 *
 * 输入样例
  3 + 5
  12 + 45 / 9
  1 / 2
  1 / 0
  12 + 34 * 56 - 78
  455 - 144 / 18 + 156
 *
 * 输出样例
 * 8
 * 17
 * 0
 * err
 * 1838
 * 603
 * Created by zhouyanhui3 on 19-11-6.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String answer = solution(line);
             System.out.println(answer);
        }
    }

    private static String solution(String line) {
        String[] split = line.split(" ");
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        for (String s : split) {
            if(s.equalsIgnoreCase("+")){
                String ret = calcBefore(opStack, integerStack);
                if(ret!=null){
                    return ret;
                }
                opStack.push('+');
            }else if(s.equalsIgnoreCase("-")){
                String ret = calcBefore(opStack, integerStack);
                if(ret!=null){
                    return ret;
                }
                opStack.push('-');
            }else if(s.equalsIgnoreCase("*")){
                String ret = calcBeforeHighLevel(opStack, integerStack);
                if(ret!=null){
                    return ret;
                }
                opStack.push('*');
            }else if(s.equalsIgnoreCase("/")){
                String ret = calcBeforeHighLevel(opStack, integerStack);
                if(ret!=null){
                    return ret;
                }
                opStack.push('/');
            }else{
                int val = Integer.valueOf(s);
                integerStack.push(val);
            }
        }
        String ret = calcBefore(opStack, integerStack);
        if(ret != null){
            return ret;
        }
        if(integerStack.isEmpty()){
            return "err";
        }
        return String.valueOf(integerStack.pop());
    }

    private static String calcBeforeHighLevel(Stack<Character> opStack, Stack<Integer> integerStack) {
        while(!opStack.isEmpty()){
            Character top = opStack.peek();
            if(top == '+' || top == '-'){
                break;
            }
            if(integerStack.isEmpty()){
                return "err";
            }
            int b = integerStack.pop();
            if(integerStack.isEmpty()){
                return "err";
            }
            int a = integerStack.pop();
            Character pop = opStack.pop();
            if(pop == '*'){
                integerStack.push(a * b);
            }else{
                if(b == 0){
                    return "err";
                }
                integerStack.push(a / b);
            }
        }
        return null;
    }

    private static String calcBefore(Stack<Character> opStack, Stack<Integer> integerStack) {
        while(!opStack.isEmpty()){
            if(integerStack.isEmpty()){
                return "err";
            }
            int b = integerStack.pop();
            if(integerStack.isEmpty()){
                return "err";
            }
            int a = integerStack.pop();
            Character pop = opStack.pop();
            if(pop == '+') {
                integerStack.push(a + b);
            }else if(pop == '-'){
                integerStack.push(a - b);
            }else if(pop == '*'){
                integerStack.push(a * b);
            }else{
                if(b == 0){
                    return "err";
                }
                integerStack.push(a / b);
            }
        }
        return null;
    }
}
