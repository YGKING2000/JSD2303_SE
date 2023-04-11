package io;

import java.io.*;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Test4
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 11:45
 * @Version 1.0
 */
public class Test4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        // 将字节型的数据写入文件
        FileOutputStream fos = new FileOutputStream("test2.txt");
        // 将数据从字符转换成字节
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        // 字符流的块写入，默认攒够8192个字符后一次性写入
        BufferedWriter bw = new BufferedWriter(osw);
        // 将字符串按行准备写入
        // 第二个参数是自动行刷新功能，只要调用println()方法就会自动将数据添加进入文件，不用手动调用flush()方法
        PrintWriter pw = new PrintWriter(bw);
        String code;
        while (true) {
            System.out.print("请输入任意内容：");
            code = scanner.nextLine();
            if ("exit".equalsIgnoreCase(code)) {
                System.out.println("程序已终止！");
                break;
            }
            pw.println(code);
        }
        pw.close();
    }
}
