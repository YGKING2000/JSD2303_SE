package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Description
 * @ClassName Test4
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 15:34
 * @Version 1.0
 */
public class Test4 {
    public void show() {

    }

    public void test(String s, int i) {

    }

    public void add(Object o) {

    }

    public static void main(String[] args) throws Exception {
        Package pack = Test4.class.getPackage();

        File dir = new File(Objects.requireNonNull(Test4.class.getResource("")).toURI());
        File[] files = dir.listFiles(file -> file.getName().endsWith(".class"));
        for (File file : files) {
            String className = file.getName().replace(".class", "");
            Class cls = Class.forName(pack.getName() + "." + className);
            if (cls.isAnnotationPresent(AutoRunClass.class)) {
                Method[] methods = cls.getDeclaredMethods();
                Object obj = cls.newInstance();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AutoRunMethod.class)) {
                        method.invoke(obj);
                    }
                }
            }
        }

        Method[] methods = Test4.class.getDeclaredMethods();
        for (Method method : methods) {
            Parameter[] parameters = method.getParameters();
            System.out.println(Arrays.toString(parameters));
            Class<?>[] objectClass = method.getParameterTypes();

        }
    }
}
