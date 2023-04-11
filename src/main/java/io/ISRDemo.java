package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @ClassName ISRDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 10:31
 * @Version 1.0
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        int code;
        while ((code = isr.read()) != -1) {
            System.out.print((char) code);
        }
        isr.close();
    }
}
