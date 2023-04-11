package homework.day03.second;

import java.io.*;

/**
 * @Description 将当前目录下的所有obj文件获取到，并进行反序列化后输出每个用户的信息(直接输出反序列化后的User对象即可)
 * @ClassName Test01
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 13:02
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1.获取当前目录并赋值给File对象dir
        File dir = new File(".");
        // 2.将dir中所有文件名以”.obj“结尾的文件添加进File数组并赋值给subs
        File[] subs = dir.listFiles((f) -> f.getName().endsWith(".obj"));
        // 3.遍历subs数组中的元素File对象
        for (int i = 0; i < subs.length; i++) {
            // 4.将数组的每一个元素依次赋值给File对象sub
            File sub = subs[i];
            // 5.创建File对象sub所指向的文件与程序之间的文件输入流
            FileInputStream fis = new FileInputStream(sub);
            // 6.将对象输入流连接到文件输入流上
            ObjectInputStream ois = new ObjectInputStream(fis);
            // 7.调用对象输出流身上的readObject()方法，反序列化读取一个对象并赋值给Object对象obj
            Object obj = ois.readObject();
            // 8.判断对象变量obj所指向的对象是否是User或者User派生类的实例
            if (obj instanceof User) {
                // 9.将obj向下造型成User类并赋值给user
                User user = (User) obj;
                // 10.输出user对象的信息
                System.out.println(user);
            }
        }
    }
}
