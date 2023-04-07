package file;

import java.io.File;

/**
 * @Description File类的演示
 * @ClassName FileDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 09:54
 * @Version 1.0
 */
public class FileDemo {
    public static void main(String[] args) {
        // File file = new File("C:/Users/YGKING/IdeaProjects/JSD2303_SE/demo.txt");
        File file = new File("./demo.txt");
        // 1.String getName(): 获取文件名称
        String name = file.getName();
        System.out.println(name);// demo.txt

        // 2.long length(): 获取当前文件内容的大小，单位是字节(byte)
        long length = file.length();
        System.out.println("占用字节数为:" + length);// 占用字节数为:6

        // 3.boolean canRead(): 文件是否可读
        boolean cr = file.canRead();
        System.out.println(cr);// true

        // 4.boolean canWrite(): 文件是否可写
        boolean cw = file.canWrite();
        System.out.println(cw);// true

        // 5.boolean isHidden(): 文件是否被隐藏
        boolean ih = file.isHidden();
        System.out.println(ih);// false

        // 6.boolean exists(): 判断文件或者目录是否已存在
        boolean exist = file.exists();
        if (exist) {
            System.out.println("该文件已存在");
        } else {
            System.out.println("文件不存在");
        }
    }
}
