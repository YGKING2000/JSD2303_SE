package homework.day02.first;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @ClassName Test01
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 20:01
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        if (directory.isDirectory()) {
            File[] files = directory.listFiles(File::isFile);
            if (files != null && files.length > 0) {
                for (File file : files) {
                    FileInputStream fis = new FileInputStream(file);
                    String[] data = file.getName().split("\\.");
                    FileOutputStream fos = new FileOutputStream(data[0] + "_cp." + data[1]);
                    int result;
                    while ((result = fis.read()) != -1) {
                        fos.write(result);
                    }
                }
            }
        }
    }
}
