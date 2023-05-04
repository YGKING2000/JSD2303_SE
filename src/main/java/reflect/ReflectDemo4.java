package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @Description
 * @ClassName ReflectDemo4
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 09:23
 * @Version 1.0
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        /*
         Person person = new Person();
         person.playGame();

         Class cls = Class.forName("reflect.Person");
         Object obj = cls.newInstance();
         获取playMethod方法
         Method method = cls.getMethod("playGame");
         method.invoke(person);
        */

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入类名:");
        String className = scanner.nextLine();
        System.out.print("请输入方法名:");
        String methodName = scanner.nextLine();
        System.out.print("请输入信息:");
        String info = scanner.nextLine();
        System.out.print("请输入次数:");
        int count = scanner.nextInt();

        Class cls = Class.forName(className);
        Method method = cls.getMethod(methodName);
        Object obj = cls.newInstance();
        method.invoke(obj);
    }
}
