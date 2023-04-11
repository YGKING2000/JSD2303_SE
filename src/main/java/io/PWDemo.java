package io;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description
 * @ClassName PWDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 10:55
 * @Version 1.0
 */
public class PWDemo {
    public static void main(String[] args) throws IOException {
        // PrintWriter的字符
        PrintWriter pw = new PrintWriter("pw.txt", "utf-8");
        pw.print("你说爱像云");
        pw.print("要自在飘浮才美丽");

        // 输出流都需要手动关闭
        pw.close();
    }
}
