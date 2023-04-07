package homework.day01.second;

import java.io.File;
import java.io.FileFilter;

/**
 * @Description
 * @ClassName Test02
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 21:21
 * @Version 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        File directory = new File(".");
        if (directory.isDirectory()) {
            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().contains("s");
                }
            });
            if (files != null && files.length > 0) {
                for (File file : files) {
                    System.out.println("当前文件夹下文件名称中");
                    System.out.print(file.getName() + "  ");
                }
            }
        }
    }
}
