package homework.day01.second;

import java.io.File;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Test03
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 08:26
 * @Version 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入关键词：");
        String keyword = scanner.next();
        File directory = new File(".");
        File[] files = directory.listFiles(file -> file.getName().contains(keyword));
        if (files != null && files.length > 0) {
            System.out.println("当前目录下名称中包含有'" + keyword + "'的文件或者目录有：");
            for (File file : files) {
                System.out.print(file.getName() + "  ");
            }
            System.out.println();
        } else {
            System.out.print("当前目录下没有名称中包含'" + keyword + "'的文件或者目录\n");
        }
    }
}
