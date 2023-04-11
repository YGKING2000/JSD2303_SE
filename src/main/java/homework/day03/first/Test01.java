package homework.day03.first;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Description 将当前目录下的所有obj文件获取到，并进行反序列化后输出每个用户的信息(直接输出反序列化后的User对象即可)
 * @ClassName Test01
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 08:26
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1.获取当前目录
        File dir = new File(".");
        // 2.获取当前目录下以".obj"结尾的文件数组
        File[] subs = dir.listFiles((f) -> f.getName().endsWith(".obj"));
        // 3.遍历当前目录下以".obj"结尾的文件数组
        for (int i = 0; i < subs.length; i++) {
            // 4.将数组中的每一个文件依次取出来赋值给File类变量sub
            File sub = subs[i];
            // 5.建立程序与文件之间的文件流
            FileInputStream fis = new FileInputStream(sub);
            // 6.将对象流链接在文件流上
            ObjectInputStream ois = new ObjectInputStream(fis);
            // 7.利用对象ois身上的readObject()方法进行反序列化，将对象的数据和结构信息读取出来还原成一个Java对象
            Object obj = ois.readObject();
            // 8.判断对象obj是否是User或者User的派生类的实例
            if (obj instanceof User) {
                // 9.将obj向下强制转换后用User对象user接收
                User user = (User) obj;
                // 10.将user对象的信息在控制台输出
                System.out.println(user);
            }
        }
    }
}
