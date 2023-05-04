package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description
 * @ClassName ReflectDemo1
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/20 16:17
 * @Version 1.0
 */
public class ReflectDemo1 {
    public static void main(String[] args) {
        /* 获取类对象的方法
         * 1. Class cls1 = String.class;
         * 2. String str = "";
         *    Class cls2 = str.getClass();
         * 3. Class cls3 = Class.forName("java.lang.String");
         * cls1 == cls2 == cls3 为true
         */

        // Class cls = ArrayList.class;
        // ArrayList arrayList = new ArrayList();
        // Class cls2 = arrayList.getClass();
        // System.out.println(cls2 == cls);// true

        // Class cls = String.class;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入类的完全限定名: ");
        String path = scanner.next();
        Class cls = null;
        try {
            cls = Class.forName(path.trim());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String name = cls.getName();
        System.out.println(name);// java.lang.String
        name = cls.getSimpleName();
        System.out.println(name);// String

        // String getName(): 获取类对象的完全限定名(包名+类名)
        // String getSimpleName(): 获取类对象的类名
        Class cls1 = StringBuilder.class;
        System.out.println(cls1.getName());// java.lang.StringBuilder
        System.out.println(cls1.getSimpleName());// StringBuilder

        // Package getPackage(): 获取当前类对象的包对象
        String packageName = cls.getPackage().getName();
        System.out.println(packageName);// java.lang

        // Method[] getMethods(): 获取当前类对象的每一个公开方法(包括从超类继承来的)
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
