package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @ClassName Test
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 09:09
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("abc.txt");
        FileOutputStream fos = new FileOutputStream(file);
        for (int i = 0; i < 26; i++) {
            fos.write(97 + i);
        }
        System.out.println(file.length());
    }
}
