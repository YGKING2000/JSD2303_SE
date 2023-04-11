package homework.day03.first;

import java.io.*;

/**
 * @Description 扫描指定目录中的所有.java文件，并将内容全部输出到控制台
 * 例如: 将当前项目目录下src/io目录中的所有java文件内容输出到控制台
 * @ClassName Test03
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 12:39
 * @Version 1.0
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        // 1.获取指定目录
        File dir = new File("./src/main/java/io");
        // 2.将指定目录下dir下的".java"文件添加File数组subs中
        File[] subs = dir.listFiles(f -> f.getName().endsWith(".java"));
        // 3.遍历subs数组的元素
        for (int i = 0; i < subs.length; i++) {
            // 4.将subs中的每一个元素依次赋值给File变量sub
            File sub = subs[i];
            // 5.创建文件与程序之间的缓冲输入字符流，并依次连接在了转换流、文件流上
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(sub)
                    )
            );
            // 6.声明String变量line用以接收读取的行字符串
            String line;
            // 7.不断地从文件中读取行字符串，直到文件末尾返回值为null为止
            while ((line = br.readLine()) != null) {
                // 8.在控制台打印从文件中读取得到的行字符串
                System.out.println(line);
            }
        }
    }
}
