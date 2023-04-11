package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description 文件输出流FileOutputStream的演示
 * @ClassName FOSDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 16:36
 * @Version 1.0
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        // FileOutputStream文件输出流有两个构造器，可以选择传入文件路径或者File对象
        // 1.FileOutputStream(String pathname)
        // FileOutputStream fos = new FileOutputStream("fos.dat");

        // 2.FileOutputStream(File file)
        File file = new File("fos.dat");
        FileOutputStream fos = new FileOutputStream(file);

        System.out.println(file.length());// 0
        // void write(int num):该方法只读取该数据二进制反码的最低的8位
        // 例如：int类型的256二进制反码为: 00000000 00000000 00000001 00000000
        // 利用write()方法写入进去时只取最低8位: 00000000,在读取出来时就变成了十进制的0
        fos.write(256);
        System.out.println(file.length());// 1
        fos.write(1);
        System.out.println(file.length());// 2
        fos.write(Integer.MAX_VALUE);
        fos.close();
        System.out.println(file.length());// 3
    }
}
