package homework.day02.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description 修改程序，完成文件复制的操作
 * @ClassName Test02
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/08 19:14
 * @Version 1.0
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        FileOutputStream fos = new FileOutputStream("test_cp.txt");

        int d;
        while ((d = fis.read()) != -1) {
            fos.write(d);
        }
        System.out.println("复制完毕!");
        fis.close();
        fos.close();
    }
}
