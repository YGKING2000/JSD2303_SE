package io;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description 利用块读取和块写入快速复制图片
 * @ClassName CopyDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 10:30
 * @Version 1.0
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("ikun.jpg");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("ikun1.jpg");
        byte[] data = new byte[1024 * 10];
        long start = System.currentTimeMillis();
        while (true) {
            int length = fis.read(data);
            if (length == -1) {
                break;
            } else {
                // fos.write(data);
                fos.write(data, 0, length);
            }
        }
        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);
    }
}
