package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Test3
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 09:55
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream("test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        String code;
        do {
            System.out.print("请输入任意内容：");
            code = scanner.nextLine();
            if ("exit".equals(code)) {
                System.out.println("程序已退出");
                break;
            }
            osw.write(code + "\n");
        } while (true);
        osw.close();
    }
}
