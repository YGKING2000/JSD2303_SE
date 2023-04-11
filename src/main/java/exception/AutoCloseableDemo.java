package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @ClassName AutoCloseableDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 16:34
 * @Version 1.0
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (
            FileOutputStream fos = new FileOutputStream("");
        ) {
            fos.write(128);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
