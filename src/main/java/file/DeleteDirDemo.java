package file;

import java.io.File;

/**
 * @Description
 * @ClassName DeleteDirDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 11:54
 * @Version 1.0
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        File dir = new File("demo");
        if (dir.exists()) {
            dir.delete();
            System.out.println("删除成功");
        } else {
            System.out.println("该目录不存在");
        }
    }
}
