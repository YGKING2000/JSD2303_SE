package reflect;

import java.util.Scanner;

/**
 * @Description
 * @ClassName ReflectDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/20 17:12
 * @Version 1.0
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个类名:");
        Class cls = Class.forName(scanner.next());
        Object obj = cls.newInstance();
        System.out.println(obj);
    }
}
