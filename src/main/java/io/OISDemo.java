package io;

import java.io.*;

/**
 * @Description
 * @ClassName OISDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 09:11
 * @Version 1.0
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("胡歌", 18, "男", new String[]{"帅气", "演技好", "谦逊有礼"});
        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.close();

        FileInputStream fis = new FileInputStream("person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person person1 = (Person) ois.readObject();
        System.out.println(person1);
        ois.close();
    }
}
