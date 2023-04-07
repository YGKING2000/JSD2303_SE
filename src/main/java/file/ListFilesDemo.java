package file;

import java.io.File;

/**
 * @Description 利用File对象查看当前目录下的所有子项
 * @ClassName ListFilesDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 14:07
 * @Version 1.0
 */
public class ListFilesDemo {
    public static void main(String[] args) {
        File dir = new File(".");
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                System.out.println("一共有" + files.length + "个子项");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("当前指向的不是一个文件夹");
        }
    }
}
