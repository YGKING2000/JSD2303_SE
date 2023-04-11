package homework.day02.second;

import java.io.*;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Test04
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/08 20:46
 * @Version 1.0
 */
public class Test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String name, pwd, gender;
        int age;
        do {
            System.out.print("请输入用户名:");
            name = scanner.nextLine().trim();
        } while (!(name.matches("[\\w]{1,32}")));

        do {
            System.out.print("请输入密码:");
            pwd = scanner.nextLine().trim();
        } while (!(pwd.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{6,16}$")));

        do {
            System.out.print("请输入性别:");
            gender = scanner.nextLine().trim();
        } while (!(gender.equals("男") || gender.equals("女")));

        do {
            System.out.print("请输入年龄:");
            age = scanner.nextInt();
        } while (age < 0);

        User user = new User(name, pwd, gender, age);
        FileOutputStream fos = new FileOutputStream(name + ".obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(user);

        FileInputStream fis = new FileInputStream(name + ".obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user1 = (User) ois.readObject();
        System.out.println(user1);
    }
}
