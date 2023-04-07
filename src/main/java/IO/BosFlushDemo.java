package IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description flush()会将目前缓冲区的内容一次性写入文件
 * @ClassName BosFlushDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 16:42
 * @Version 1.0
 */
public class BosFlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // fos.write("我怀念的是我无话不说\n我怀念的是一起做梦".getBytes(StandardCharsets.UTF_8));
        bos.write("我怀念的是我无话不说\n我怀念的是一起做梦".getBytes(StandardCharsets.UTF_8));
        bos.flush();
        // 在调用close()方法关闭缓冲输出流时，会自动调用1次flush方法，将所有byte数组中的内容写入
        bos.close();
    }
}
