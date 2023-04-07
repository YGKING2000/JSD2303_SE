package homework.day01.first;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Description 程序启动后，要求用户输入一个文件名，如果文件存在则提示
 *              并要求用户更换，直到该文件还不存在为止，然后将这个文件
 *              在当前目录中创建出来
 * @ClassName Test1
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 20:48
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你想创建的文件名称：");
        do {
            String name = scanner.next();
            File file = new File(name);
            if (!file.exists()) {
                boolean flag = file.createNewFile();
                if (flag) {
                    System.out.println("文件创建成功！");
                    break;
                } else {
                    System.out.print("文件创建失败，请重新输入文件名称：");
                }
            } else {
                System.out.print("文件已存在，请重新输入文件名称：");
            }
        } while (true);
    }
}
