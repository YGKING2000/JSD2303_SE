package file;

import java.io.File;

/**
 * @Description 利用File对象删除文件
 * @ClassName DeleteFileDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 11:11
 * @Version 1.0
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println(file.delete());
        File file1 = new File("test");
        System.out.println(file1.delete());
    }
}
