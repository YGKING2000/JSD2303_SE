package IO;

import java.io.*;

/**
 * @Description
 * @ClassName CopyDemo3
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 15:41
 * @Version 1.0
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("image.png");
        FileOutputStream fos = new FileOutputStream("image1.png");

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        /*int data;
        long start = System.currentTimeMillis();
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");// 耗时14675ms*/

        int data;
        long start = System.currentTimeMillis();
        while ((data = bis.read()) != -1) {
            bos.write(data);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");// 耗时83ms

        // fis.close();
        // fos.close();
        bis.close();
        bos.close();
    }
}
