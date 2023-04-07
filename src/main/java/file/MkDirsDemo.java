package file;

import java.io.File;

/**
 * @Description 利用File对象创建多级目录
 * @ClassName MkDirsDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 11:43
 * @Version 1.0
 */
public class MkDirsDemo {
    public static void main(String[] args) {
        File dir = new File("a/b/c/d/e/f/g");
        if (dir.exists()) {
            System.out.println("该目录已存在");
        } else {
            if (dir.mkdirs()) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        }
    }
}
