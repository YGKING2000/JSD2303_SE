package homework.day02.second;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @ClassName Test01
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 23:46
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        if (directory.isDirectory()) {
            File[] files = directory.listFiles(File::isFile);
            if (files != null && files.length > 0) {
                for (File file : files) {
                    String name = file.getName();
                    String[] data = name.split("[.]");
                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(data[0] + "_cp." + data[1]);
                    int d;
                    while ((d = fis.read()) != -1) {
                        fos.write(d);
                    }
                }
            }
        }
    }
}
