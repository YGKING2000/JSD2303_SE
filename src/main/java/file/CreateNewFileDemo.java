package file;

import java.io.File;
import java.io.IOException;

/**
 * @Description 利用File对象创建新文件
 * @ClassName CreateNewFileDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 10:43
 * @Version 1.0
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建一个File类的对象file
        File file = new File("./test.txt");
        // 2.创建这个文件
        boolean flag = file.createNewFile();
        if (flag) {
            System.out.println("创建成功");
        } else {
            System.out.println("文件已存在");
        }
    }
}
