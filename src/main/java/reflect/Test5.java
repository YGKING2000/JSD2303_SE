package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Description
 * @ClassName Test5
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 16:43
 * @Version 1.0
 */
public class Test5 {
    /*public static void main(String[] args) throws Exception {
        Package pack = Test4.class.getPackage();
        File dir = new File(Objects.requireNonNull(Test5.class.getResource("")).toURI());
        File[] files = dir.listFiles(file -> file.getName().endsWith(".class"));
        assert files != null;
        for (File file : files) {
            String className = file.getName().replace(".class", "");
            Class cls = Class.forName(pack.getName() + "." + className);
            if (cls.isAnnotationPresent(AutoRunClass.class)) {
                Object obj = cls.newInstance();
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AutoRunMethod.class)) {
                        AutoRunMethod autoRunMethod = method.getAnnotation(AutoRunMethod.class);
                        int value = autoRunMethod.value();
                        for (int i = 0; i < value; i++) {
                            method.invoke(obj);
                        }
                    }
                }
            }
        }
    }*/
    public static void main(String[] args) throws Exception {
        Package pack = Test5.class.getPackage();
        File dir = new File(Objects.requireNonNull(Test5.class.getResource("")).toURI());
        File[] files = dir.listFiles(file -> file.getName().endsWith(".class"));
        assert files != null;
        for (File file : files) {
            String className = file.getName().replace(".class", "");
            Class cls = Class.forName(pack.getName() + "." + className);
            if (cls.isAnnotationPresent(AutoRunClass.class)) {
                Object obj = cls.newInstance();
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AutoRunMethod.class)) {
                        AutoRunMethod autoRunMethod = method.getAnnotation(AutoRunMethod.class);
                        int value = autoRunMethod.value();
                        for (int i = 0; i < value; i++) {
                            method.invoke(obj);
                        }
                    }
                }
            }
        }
    }
}
