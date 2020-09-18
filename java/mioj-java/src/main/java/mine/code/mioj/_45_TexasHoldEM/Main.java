package mine.code.mioj._45_TexasHoldEM;

/**
 * - 德州扑克
 * 序号：#45
 * 难度：困难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 德州扑克是风靡全球的一种扑克游戏。扑克有四种花色，分别为黑桃（S）、红桃（H）、梅花（C）、方片（D）。每种花色有13张牌，从小到大分别为2、3、4、5、6、7、8、9、10、J、Q、K、A。
 *
 * 考虑德州扑克中的如下三种牌形： 同花顺（Straight Flush）：同一花色，并且连续的五张牌。 例如：{SK SQ SJ S10 S9} 对于连续的五张牌，有一个特例，即 {A、2、3、4、5} 也算作连续的五张牌。但 {K、A、2、3、4}，{Q、K、A、2、3}，{J、Q、K、A、2} 不算作连续的五张牌。
 *
 * 同花（Flush）：同一花色但不连续的五张牌。 例如：{H10 H7 H4 H3 H2}
 *
 * 顺子（Straight）：连续但不是同一花色的五张牌。 例如：{SA H2 D3 C4 D5}
 *
 * 这三种牌形的大小关系是：顺子 < 同花 < 同花顺。 现在，我们为了游戏的趣味性，在扑克中加入了5张魔术牌（用M表示），你可以将每张魔术牌变成你想要的任何一张牌。 你从牌堆里随机抽了五张牌，请你给出最大可能的牌形。如果三种牌形都无法组成，请输出GG。
 *
 * 输入
 * 一行字符串，表示使用空格分隔的五张牌，每张牌由花色与点数组成(或使用M来表示魔术牌)。
 *
 * 输出
 * 单组输入。 一行字符串，表示能够组成的最大牌形。 只有Flush、Straight、Straight Flush、GG四种结果。
 *
 * 输入样例
 * H10 H7 H4 H3 H2
 * M SA H2 D3 C4
 * M M M M D4
 * S8 HJ DA H8 H5
 * H8 M M C5 H9
 *
 * 输出样例
 * Flush
 * Straight
 * Straight Flush
 * GG
 * Straight
 *
 *
 * Created by zhouyanhui3 on 19-11-18.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String answer = solution(line);
            System.out.println(answer);
        }
    }

    private static String solution(String line) {
        String[] split = line.split(" ", 5);
        int mNum = 0;
        List<String> cards = new ArrayList<>();
        for (String s : split) {
            if(s.equalsIgnoreCase("M")){
                mNum++;
            }else{
                cards.add(s);
            }
        }
        switch (mNum){
            case 4:
                return "Straight Flush";
            case 3:
            case 2:
            case 1:
            case 0:
                return check(cards, mNum);
                default:
                    return "wrong input";
        }

    }

    private static String check(List<String> cards, int m) {
        Set<Character> colors = new HashSet<>();
        List<Integer> cardNums = new ArrayList<>();
        for (String card : cards) {
            colors.add(card.charAt(0));
            cardNums.add(toNum(card.substring(1)));
        }
        Collections.sort(cardNums);
        boolean sameColor = colors.size() == 1;
        boolean inorder = true;
        for (int i = 1; i < cardNums.size(); i++) {
            if(cardNums.get(i-1).equals(cardNums.get(i))){
                inorder = false;
                break;
            }
        }
        if(inorder){
            int max = cardNums.get(cardNums.size() - 1);
            int min = cardNums.get(0);
            if(max - min <= 4){
                inorder = true;
            }else{
                inorder = false;
                if(max == 14){
                    int revSecond = cardNums.size() - 2;
                    if(cardNums.get(revSecond) - 1 <= 4){
                        inorder = true;
                    }
                }
            }
        }

        return generateResult(sameColor, inorder);
    }

    private static String generateResult(boolean sameColor, boolean inorder) {
        if(!inorder){
            if(sameColor){
                return "Flush";
            }else{
                return "GG";
            }
        }else{
            if(sameColor){
                return "Straight Flush";
            }else{
                return "Straight";
            }
        }
    }

    private static int toNum(String s) {
        if(s.equalsIgnoreCase("J")){
            return 11;
        }
        if(s.equalsIgnoreCase("Q")){
            return 12;
        }
        if(s.equalsIgnoreCase("K")){
            return 13;
        }
        if(s.equalsIgnoreCase("A")){
            return 14;
        }
        return Integer.valueOf(s);
    }
}
