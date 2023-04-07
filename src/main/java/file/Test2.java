package file;

import java.io.File;

/**
 * @Description 利用File对象删除当前项目目录下的100个文件
 * @ClassName Test2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 11:15
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            File file = new File("test/test" + i + ".txt");
            file.delete();
        }
        File file = new File("test");
        file.delete();
    }
}
