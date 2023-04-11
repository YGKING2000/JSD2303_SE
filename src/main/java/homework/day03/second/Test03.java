package homework.day03.second;

import java.io.*;

/**
 * @Description 扫描指定目录中的所有.java文件，并将内容全部输出到控制台
 * 例如: 将当前项目目录下src/io目录中的所有java文件内容输出到控制台
 * @ClassName Test03
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 13:22
 * @Version 1.0
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        // 1.获取指定目录并赋值给dir
        File dir = new File("./src/main/java/io");
        // 2.将dir中所有文件名以".java"结尾的文件添加进入File数组并赋值给subs
        File[] subs = dir.listFiles(f -> f.getName().endsWith(".java"));
        // 3.遍历subs数组中的每一个元素————File对象
        for (int i = 0; i < subs.length; i++) {
            // 4.将数组中的每一个File对象赋值给File对象sub
            File sub = subs[i];
            // 5.创建sub所指向的文件和程序之间的缓冲输入字符流，并连接在了转换输入流、文件输入流上
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(sub)
                    )
            );
            // 6.声明一个String变量line用以接受从文件中读取出来的行字符串
            String line;
            // 7.不断地从文件中读取行字符串出来，直到读取到文件末尾返回值为null为止
            while ((line = br.readLine()) != null) {
                // 8.将读取到的行字符串不断打印输出到控制台上
                System.out.println(line);
            }
        }
    }
}
