package homework.day02.first;

import java.io.*;

/**
 * @Description 修改程序
 * @ClassName Test03
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 20:35
 * @Version 1.0
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("test_cp.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int d;
        while ((d = bis.read()) != -1) {
            bos.write(d);
        }
        bos.flush();
        bos.close();
        System.out.println("复制完毕!");

    }
}
