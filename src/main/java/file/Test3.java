package file;

import java.io.File;

/**
 * @Description 利用File对象获取指定目录下的指定子项
 * @ClassName Test3
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 14:54
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        File dir = new File(".");
        if (dir.isDirectory()) {
            // File[] files = dir.listFiles(file -> file.getName().indexOf("a") != -1);
            File[] files = dir.listFiles(file -> file.getName().contains("a"));
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
