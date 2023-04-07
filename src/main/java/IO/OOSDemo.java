package IO;

import java.io.*;

/**
 * @Description 使用对象输出流完成对象序列化操作并最终保存到文件person.obj中
 * @ClassName OOSDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 17:24
 * @Version 1.0
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("胡歌", 18, "男", new String[] {"帅气", "演技好", "谦逊有礼", "上海"});
        FileOutputStream fos = new FileOutputStream("person.obj");
        FileInputStream fis = new FileInputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectInputStream ois = new ObjectInputStream(fis);

        oos.writeObject(person);
        oos.close();
        Person obj = (Person) (ois.readObject());
        System.out.println(obj.toString());
    }
}
