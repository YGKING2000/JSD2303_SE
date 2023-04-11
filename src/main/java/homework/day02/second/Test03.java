package homework.day02.second;

import java.io.*;

/**
 * @Description 修改程序，使得程序能使用缓冲流完成文件复制
 * @ClassName Test03
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/08 20:39
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
