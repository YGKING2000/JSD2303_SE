package io;

import java.io.*;

/**
 * @Description
 * @ClassName BRDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 14:08
 * @Version 1.0
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String code;
        while ((code = br.readLine()) != null) {
            System.out.println(code);
        }
    }
}
