package homework.day01.second;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Test01
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 21:15
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你想创建的文件名称：");
        do {
            String name = scanner.next();
            File file = new File(name);
            if (file.exists()) {
                System.out.print("文件已存在，请重新输入文件名称：");
            } else {
                boolean flag = file.createNewFile();
                if (flag) {
                    System.out.print("文件创建成功");
                    break;
                } else {
                    System.out.print("文件创建失败，请重新输入文件名称：");
                }
            }
        } while (true);
    }
}
