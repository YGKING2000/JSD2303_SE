package file;

import java.io.File;

/**
 * @Description 利用File对象创建文件夹
 * @ClassName MkDirDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 11:33
 * @Version 1.0
 */
public class MkDirDemo {
    public static void main(String[] args) {
        File dir = new File("demo");
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("文件夹创建成功");
            } else {
                System.out.println("文件创建失败");
            }
        } else {
            System.out.println("创建失败，该目录已存在");
        }
    }
}
