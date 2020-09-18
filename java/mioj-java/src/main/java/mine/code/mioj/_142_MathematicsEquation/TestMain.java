package mine.code.mioj._142_MathematicsEquation;

import java.io.IOException;

public class TestMain {
    public static void main(String args[]) throws IOException {
        long start = System.currentTimeMillis();
        Main.solution("-14 -42 -23 27 -48");
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }
}

