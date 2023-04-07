package homework.day01.first;

import java.io.File;
import java.util.Scanner;

/**
 * @Description 程序启动后要求用户输入一个关键字，然后列出当前项目下所有
 *              名字中包含该关键字的子项
 * @ClassName Test03
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 21:04
 * @Version 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入关键词：");
        String keyword = scanner.next();
        File directory = new File(".");
        if (directory.isDirectory()) {
            File[] files = directory.listFiles(file -> file.getName().contains(keyword));
            if (files != null && files.length > 0) {
                System.out.println("名称中包含有\"" + keyword + "\"的文件和目录有:");
                for (File file : files) {
                    System.out.print(file.getName() + "  ");
                }
            } else {
                System.out.print("当前文件夹中没有名称包含有\"" + keyword + "\"的文件或者目录");
            }
        }
    }
}
