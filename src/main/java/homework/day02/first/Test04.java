package homework.day02.first;

import java.io.*;
import java.util.Scanner;

/**
 * @Description 当前程序启动后要求用户顺序输入以上四个信息，然后实例化一个User对象保存着四个信息，并将该对象序列化到文件中
 * 文件名的命名规则:用户名.obj，比如该用户输入用户名为张三，那么这个对象序列化后的文件名为:张三.obj
 *
 * 提高(选做):
 * 可以在用户输入信息后做必要的格式验证，比如4个信息是否都输入内容了，不能有空的
 * 用户名只能包含字母数字下划线，并且1-32位
 * @ClassName Test04
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 20:40
 * @Version 1.0
 */
public class Test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String name, pwd, nick;
        int age;
        // 获取用户名
        do {
            System.out.print("请输入用户姓名：");
            name = scanner.nextLine();
        } while (!name.trim().matches("[\\w]{1,32}"));

        // 获取密码
        do {
            System.out.print("请输入密码：");
            pwd = scanner.nextLine();
        } while (!(pwd.trim().length() >= 6));

        // 获取昵称
        System.out.print("请输入昵称：");
        nick = scanner.nextLine();
        while (!(nick.trim().length() > 0)) {
            System.out.print("请输入昵称：");
            nick = scanner.nextLine();
            System.out.println(nick);
        }
        // 获取年龄
        do {
            System.out.print("请输入年龄：");
            age = scanner.nextInt();
        } while (age < 0);
        // 创建Person对象
        User user = new User(name, pwd, nick, age);
        // 利用文件输出流创建写入通道并创建文件
        FileOutputStream fos = new FileOutputStream(name + ".obj");
        // 创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // 写入对象
        oos.writeObject(user);

        FileInputStream fis = new FileInputStream(name + ".obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object person1 = ois.readObject();
        System.out.println(person1);
    }
}
