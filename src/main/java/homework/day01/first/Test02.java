package homework.day01.first;

import java.io.File;
import java.io.FileFilter;

/**
 * @Description 列出当前目录中所有名字包含s的子项
 *              使用匿名内部类和lambda两种写法
 * @ClassName Test02
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 20:58
 * @Version 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        File directory = new File(".");
        if (directory.isDirectory()) {
            /*File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().contains("s");
                }
            });*/

            File[] files = directory.listFiles(file -> file.getName().contains("s"));
            if (files != null && files.length > 0) {
                for (File file : files) {
                    System.out.print(file.getName() + "  ");
                }
            } else {
                System.out.print("当前文件夹中没有名称包含有\"s\"的文件或者目录");
            }
        }
    }
}
