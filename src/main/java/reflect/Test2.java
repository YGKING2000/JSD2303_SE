package reflect;

import reflect.annotations.AutoRunClass;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;

/**
 * @Description 调用当前类Test2的同一个包下的其他类的所有公开无参方法
 * @ClassName Test2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 11:01
 * @Version 1.0
 */
@AutoRunClass
public class Test2 {
    public static void main(String[] args) throws Exception {
        // 获取当前类对象
        Class cls = Test2.class;
        // 获取当前类的包对象
        Package pack = cls.getPackage();
        System.out.println(pack.getName());// reflect.demo

        // 获取当前类的父目录
        File dir = new File(Objects.requireNonNull(cls.getResource(".")).toURI());
        // 获取当前类的父目录中所有.class文件
        File[] files = dir.listFiles(file -> file.getName().endsWith(".class"));

        assert files != null;
        for (File file : files) {
            // 依次获取当前类的父目录中.class文件的文件名
            String className = file.getName().replaceAll("(.class){1}", "");

            // 依次获取当前类的父目录中.class文件的类对象
            Class otherClass = Class.forName(pack.getName() + "." + className);
            Object obj = otherClass.newInstance();
            Method[] methods = otherClass.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getModifiers() == Modifier.PUBLIC && method.getParameterCount() == 0) {
                    method.invoke(obj);
                }
            }
        }
    }
}
