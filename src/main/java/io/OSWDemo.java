package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @ClassName OSWDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 09:40
 * @Version 1.0
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("osw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        osw.write("我问为什么那女孩传简讯给我\n");
        osw.write("而你为什么不解释低着头沉默");

        // 字符输出流也有缓存区，需要手动flush将缓存区的数据写入或者调用close()间接调用flush方法
        osw.close();

        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        int code;
        while ((code = isr.read()) != -1) {
            System.out.print((char) code);
        }
        isr.close();
    }
}
