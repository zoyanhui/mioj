package mine.code.mioj._123_XiaoaiMonitor;

/**
 * - 小爱运维监控
 * 序号：#123
 * 难度：有挑战
 * 时间限制：1000ms
 * 内存限制：50M
 * 描述
 * 小爱后台对于每次请求服务都有一次服务质量评分告警，其数值 score 范围为 0~10, 比如：当服务出现抖动,延迟增大或者返回不合预期时，score 会增大，当服务延迟较小且返回正常时，score 会减小， 现在有一批某天的小爱服务日志，格式为：id (每次请求 id ，全局唯一), start_time (服务开始时间，inclusive), end_time(服务结束时间,exclusive),score(服务打分)， 后台系统的某一刻t的告警分数 total_socre 为 t 时刻所有处于连接状态的服务分数之和 为了计算简便， 已经将 start_time 与 end_time 转换为 unix timestamp 时间戳, 现在运维想从日志中找出一天中整个系统服务的告警分数 total_score 最大值, 要求申请的存储为常量.
 *
 * 输入
 * 输入多个以空格分隔的整数，每 4 个整数为一组（组数\lt 10^7<10
 * 7
 *  ），这 4 个整数分别代表 id, start_time, end_time, score，其值均小于 10^610
 * 6
 *  .
 *
 * 输出
 * 输出一个整数，表示 total_score 的最大值
 *
 * 输入样例
 * 1 6 10 4 2 3 8 3 3 7 9 1 4 5 6 2
 *
 * 输出样例
 * 8
 *
 *
 * Created by zhouyanhui on 2019/12/4.
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
        }
    }

    static class Group implements Comparable<Group> {
        int pos;
        boolean isEnd;
        int val;

        public Group(int pos, boolean isEnd, int score) {
            this.pos = pos;
            this.isEnd = isEnd;
            this.val = score;
        }

        @Override
        public int compareTo(Group o) {
            int compare = Integer.compare(this.pos, o.pos);
            if(compare == 0){
                if(this.isEnd && !o.isEnd){
                    return -1;
                }else if(!this.isEnd && o.isEnd){
                    return 1;
                }else{
                    return 0;
                }
            }
            return compare;
        }
    }

    private static long solution(String line) {
        String[] s = line.split(" ");
        if(s.length == 0){
            return 0;
        }
        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < s.length; i+=4) {
            String id = s[i];
            int start = Integer.valueOf(s[i+1]);
            int end = Integer.valueOf(s[i+2]);
            int score = Integer.valueOf(s[i+3]);
            Group sg = new Group(start, false, score);
            Group eg = new Group(end, true, score);
            groups.add(sg);
            groups.add(eg);
        }
        Collections.sort(groups);
        long cur = 0, max = 0;
        for (Group group : groups) {
            if(group.isEnd){
                max = Math.max(max, cur);
                cur -= group.val;
            }else{
                cur += group.val;
            }
        }
        return max;
    }
}

