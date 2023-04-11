package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @ClassName FinallyDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 16:27
 * @Version 1.0
 */
public class FinallyDemo2 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("./a.txt");
            fos.write(128);
        } catch (IOException e) {
            System.out.println("出错了!");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
