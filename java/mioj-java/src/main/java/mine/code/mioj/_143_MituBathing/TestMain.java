package mine.code.mioj._143_MituBathing;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestMain {
    public static void main(String args[]) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\zhouyanhui\\projects\\mioj\\java\\mioj-java\\src\\main\\java\\mine\\code\\mioj\\_143_MituBathing\\data.txt"));
        Scanner scan = new Scanner(fileInputStream);
        String line = scan.nextLine().trim();
        String[] s = line.split(" ", 3);
        int n = Integer.valueOf(s[0]);
        int k = Integer.valueOf(s[1]);
        int q = Integer.valueOf(s[2]);
        line = scan.nextLine().trim();
        int[] ints = Main.splitToInts(line, " ");
        line = scan.nextLine().trim();
        int a = Integer.valueOf(line);
        long start = System.currentTimeMillis();
        System.out.println(Main2.solution(n,k,q,a,ints));
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }
}

