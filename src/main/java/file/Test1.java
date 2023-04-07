package file;

import java.io.File;
import java.io.IOException;

/**
 * @Description 利用File对象在当前项目目录下创建100个文件
 * @ClassName Test1
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 10:58
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        File file = new File("test");
        file.mkdir();
        for (int i = 1; i <= 100; i++) {
            File file1 = new File("test/test" + i + ".txt");
            file1.createNewFile();
        }
    }
}
