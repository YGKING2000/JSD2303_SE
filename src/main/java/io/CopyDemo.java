package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

/**
 * @Description 复制图片
 * @ClassName CopyDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 09:41
 * @Version 1.0
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("ikun.jpg");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("ikun1.jpg");
        int code;
        /*while (true) {
            code = fis.read();
            if (code != -1) {
                fos.write(code);
            } else {
                fis.close();
                fos.close();
                break;
            }
        }*/
        long start = System.currentTimeMillis();
        while ((code = fis.read()) != -1) {
            fos.write(code);
        }
        fis.close();
        fis.close();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);
    }
}
