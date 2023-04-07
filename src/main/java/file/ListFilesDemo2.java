package file;

import java.io.File;
import java.io.FileFilter;

/**
 * @Description 利用File对象获取指定目录下的指定子项
 * @ClassName ListFilesDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 14:28
 * @Version 1.0
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        File dir = new File(".");
        /*FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".txt");
            }
        };*/
        if (dir.isDirectory()) {
            // File[] files = dir.listFiles(fileFilter);
            // File[] files = dir.listFiles(file -> file.getName().endsWith(".txt"));
            // File[] files = dir.listFiles(File::isDirectory);
            File[] files = dir.listFiles(File::isDirectory);
            // File[] files = dir.listFiles(file -> file.getName().contains("a"));
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
