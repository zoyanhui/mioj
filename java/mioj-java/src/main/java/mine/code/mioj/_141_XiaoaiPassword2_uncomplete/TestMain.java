package mine.code.mioj._141_XiaoaiPassword2_uncomplete;

import java.io.IOException;

public class TestMain {
    public static void main(String args[]) throws IOException {
        long start = System.currentTimeMillis();
        Main.calcAllPrimes();
        for (int i = 1; i <= 50000; i++) {
            long solution = Main.solution(i*10, 1000000000);
//            System.out.println(solution);
        }
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }
}

