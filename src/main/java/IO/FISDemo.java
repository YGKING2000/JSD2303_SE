package IO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description 文件输入流FileInputStream的演示
 * @ClassName FISDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 09:07
 * @Version 1.0
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fos.dat");
        // 实际上读取出来数据只有1个字节，只不过我们这里利用int类型来接受，将其从byte自动转换成int
        int num = fis.read();
        System.out.println(num);// 0
        num = fis.read();
        System.out.println(num);// 1
        num = fis.read();
        System.out.println(num);// 255
        num = fis.read();
        System.out.println(num);// -1,当已经访问到文件末尾时，后面没有数据时返回-1
    }
}
