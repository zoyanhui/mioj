package mine.code.mioj._29_CardGame;

/**
 * - 扑克游戏
 * 序号：#29
 * 难度：非常难
 * 时间限制：1000ms
 * 内存限制：10M
 * 描述
 * 两个人玩扑克比大小的游戏，规则是每个人抽五张手牌，然后按以下牌形比大小，比较规则是 ： 顺子 > 4条 > 葫芦 > 3条 > 2对 > 1对 > 单张。 这副牌已经去掉了两张joker，在比较时不考虑花色，最小2，最大A。 请写出一段程序来比较两个人手牌的大小。
 *
 * 说明：不考虑出老千的情况，即两个人的手牌共出现了五张或以上相同的点数。
 *
 * 输入
 * 使用逗号(,)分隔的两组数据。 每组数据为使用空格分隔的字符，表示两个人的手牌点数。点数可能是数字2 ~ 10，也可能是J Q K A。 点数的分布是无序的。
 *
 * 输出
 * 一个字符串，表示第一个人的输赢。 第一人赢返回 'win' ，输返回'lose'， 平返回'draw'。
 *
 * 输入样例
 * 10 10 10 10 8,J J J J 9
 * A 2 3 4 5,K Q J 10 9
 *
 * 输出样例
 * lose
 * win
 *
 * Created by zhouyanhui3 on 19-11-11.
 */
import java.util.*;

public class Main {
    private static Map<String, Integer> cardMap = new HashMap<>();
    static {
        cardMap.put("J", 11);
        cardMap.put("Q", 12);
        cardMap.put("K", 13);
        cardMap.put("A", 14);
    }

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
        String[] split = line.split(",", 2);
        if(split.length != 2){
            return "wrong input";
        }
        int[] player1 = parseCards(split[0]);
        int[] player2 = parseCards(split[1]);
        return compare(player1, player2);
    }

    private static String compare(int[] player1, int[] player2) {
        List<Integer> singleCards1 = new ArrayList<>();
        int score1 = calc(player1, singleCards1);
        List<Integer> singleCards2 = new ArrayList<>();
        int score2 = calc(player2, singleCards2);
        if(score1 == score2){
            if(singleCards1.size() < singleCards2.size()){
                return "lose";
            }
            if(singleCards1.size() > singleCards2.size()){
                return "win";
            }
            for (int i = 0; i < singleCards1.size(); i++) {
                if(singleCards1.get(i) > singleCards2.get(i)){
                    return "win";
                }
                if(singleCards1.get(i) < singleCards2.get(i)){
                    return "lose";
                }
            }
            return "draw";
        }
        return score1 > score2 ? "win" : "lose";
    }

    private static int calc(int[] player, List<Integer> singleCards) {
        Arrays.sort(player);
        if(player[0] + 1 == player[1] && player[1] + 1 == player[2] && player[2] + 1 == player[3] && player[3] + 1 == player[4]){
            return player[4] * (int)Math.pow(10, 7);
        }
        if(player[0] == player[1] && player[1] == player[2] && player[2] == player[3]){
            singleCards.add(player[4]);
            return player[3] * (int)Math.pow(10, 6);// + player[4];
        }
        if(player[1] == player[2] && player[2] == player[3] && player[3] == player[4]){
            singleCards.add(player[0]);
            return player[4] * (int)Math.pow(10, 6);// + player[0];
        }
        if(player[0] == player[1] && player[1] == player[2]){
            if(player[3] == player[4]){
                return player[2] * (int)Math.pow(10, 5) + player[4] * (int)Math.pow(10, 2);
            }else{
                singleCards.add(player[4]);
                singleCards.add(player[3]);
                return player[2] * (int)Math.pow(10, 4);// + player[4] + player[3];
            }
        }
        if(player[1] == player[2] && player[2] == player[3]){
            int score = player[3] * (int)Math.pow(10, 4);
            singleCards.add(player[4]);
            singleCards.add(player[0]);
            return score;   // + player[4] + player[0];
        }
        if(player[2] == player[3] && player[3] == player[4]){
            if(player[0] == player[1]){
                return player[4] * (int)Math.pow(10, 5) + player[1] * (int)Math.pow(10, 2);
            }else{
                singleCards.add(player[1]);
                singleCards.add(player[0]);
                return player[4] * (int)Math.pow(10, 4);// + player[1] + player[0];
            }
        }
        if(player[0] == player[1]){
            if(player[2] == player[3]){
                singleCards.add(player[4]);
                return player[3] * (int)Math.pow(10, 3) + player[1] * (int)Math.pow(10, 2);// + player[4];
            }
            if(player[3] == player[4]){
                singleCards.add(player[2]);
                return player[4] * (int)Math.pow(10, 3) + player[1] * (int)Math.pow(10, 2);// + player[2];
            }
            singleCards.add(player[4]);
            singleCards.add(player[3]);
            singleCards.add(player[2]);
            return player[1] * (int)Math.pow(10, 2);// + player[2] + player[3] + player[4];
        }
        if(player[1] == player[2]){
            if(player[3] == player[4]){
                singleCards.add(player[0]);
                return player[4] * (int)Math.pow(10, 3) + player[2] * (int)Math.pow(10, 2);// + player[0];
            }else{
                singleCards.add(player[4]);
                singleCards.add(player[3]);
                singleCards.add(player[0]);
                return player[2] * (int)Math.pow(10, 2);// + player[0] + player[3] + player[4];
            }
        }
        if(player[2] == player[3]){
            singleCards.add(player[4]);
            singleCards.add(player[1]);
            singleCards.add(player[0]);
            return player[3] * (int)Math.pow(10, 2);// + player[0] + player[1] + player[4];
        }
        if(player[3] == player[4]){
            singleCards.add(player[2]);
            singleCards.add(player[1]);
            singleCards.add(player[0]);
            return player[4] * (int)Math.pow(10, 2);// + player[0] + player[1] + player[2];
        }
        singleCards.add(player[4]);
        singleCards.add(player[3]);
        singleCards.add(player[2]);
        singleCards.add(player[1]);
        singleCards.add(player[0]);
        return 0; //player[0] + player[1] + player[2] + player[3] +player[4];
    }

    private static int[] parseCards(String s) {
        String[] split = s.split(" ", 5);
        if(split.length != 5){
            return null;
        }
        int[] p = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            Integer integer = cardMap.get(split[i]);
            if(integer != null){
                p[i] = integer;
            }else {
                p[i] = Integer.valueOf(split[i]);
            }
        }
        return p;
    }
}

