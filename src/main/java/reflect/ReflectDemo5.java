package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @Description
 * @ClassName ReflectDemo5
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 09:49
 * @Version 1.0
 */
public class ReflectDemo5 {
    /*public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入类的完全限定名:");
        String className = scanner.nextLine();
        System.out.print("请输入方法名:");
        String methodName = scanner.nextLine();
        // System.out.print("请输入信息:");
        // String info = scanner.nextLine();
        // System.out.print("请输入次数:");
        // int count = scanner.nextInt();

        Class cls = Class.forName(className);
        Object object = cls.newInstance();
        Method method = cls.getMethod(methodName);
        // Method method = cls.getMethod(methodName, String.class);
        // Method method = cls.getMethod(methodName, String.class, int.class);
        method.setAccessible(true);
        method.invoke(object);
        // method.invoke(object, info, count);
    }*/
    public static void main(String[] args) throws Exception {
        // 1.获取Class实例对象
        Class cls = Class.forName("reflect.Person");
        // 2.创建该类对象的的一个实例
        Object obj = cls.newInstance();
        Field field = cls.getDeclaredField("age");
        System.out.println(field.getModifiers() == Modifier.PRIVATE);
        field.setAccessible(true);
        System.out.println(field.get(obj));
        field.set(obj, 28);
        System.out.println(field.get(obj));

        // 3.获取指定方法名以及参数列表的方法
        Method method = cls.getMethod("say", String.class);
        Method method1 = cls.getMethod("say", String.class, int.class);
        // show方法为私有方法
        Method method2 = cls.getDeclaredMethod("show");
        // 4.调用Method对象的invoke方法并传递参数
        method.invoke(obj, "I am a teacher!");// 张三说:I am a teacher!
        method1.invoke(obj, "霸气外露，找死！", 2);// 张三说:霸气外露，找死！张三说:霸气外露，找死！
        // method.invoke(obj);// 调用失败，报NoSuchMethodException异常
        // 5.应当调用setAccessible(boolean flag)方法并将参数设置为true才能调用私有方法
        method2.setAccessible(true);
        method2.invoke(obj, null);// 我是Person类的私有方法
    }
}
