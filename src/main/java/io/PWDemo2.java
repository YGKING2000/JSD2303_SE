package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @ClassName PWDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 11:30
 * @Version 1.0
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println("徘徊过多少橱窗，住过多少旅馆");
        pw.println("才会觉得分离也并不冤枉");
        pw.close();
    }
}
