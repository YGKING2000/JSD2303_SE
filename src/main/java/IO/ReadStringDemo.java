package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @ClassName ReadStringDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 14:51
 * @Version 1.0
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("fos.txt");
        long length = file.length();
        FileInputStream fis = new  FileInputStream(file);
        byte[] data = new byte[(int) length];
        fis.read(data);

        String line = new String(data, StandardCharsets.UTF_8);
        System.out.println(line);
    }
}
