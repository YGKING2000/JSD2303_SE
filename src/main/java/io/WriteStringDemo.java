package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description 将字符串写入文件中
 * @ClassName WriteStringDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 14:03
 * @Version 1.0
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt", true);
        /*String line = "我问为什么那女孩传简讯给我\n而你为什么不解释低着头沉默";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);

        fos.write(data);
        fos.write("\n我该相信你很爱我\n不愿意敷衍我\n还是明白你已不想挽回什么".getBytes(StandardCharsets.UTF_8));*/

        fos.write("想问为什么\n我不再是你的快乐\n可是为什么\n却苦笑说我都懂了".getBytes(StandardCharsets.UTF_8));
        fos.write("\n自尊常常将人拖着\n把爱都走曲折\n假装了解是怕\n真相太赤裸裸\n狼狈比失去难受".getBytes(StandardCharsets.UTF_8));
        fos.close();
    }
}
