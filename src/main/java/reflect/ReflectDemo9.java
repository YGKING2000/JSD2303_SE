package reflect;

import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;

/**
 * @Description
 * @ClassName ReflectDemo9
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 16:32
 * @Version 1.0
 */
public class ReflectDemo9 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Method method = cls.getMethod("sayHi");
        if (method.isAnnotationPresent(AutoRunMethod.class)) {
            AutoRunMethod autoRunMethod = method.getAnnotation(AutoRunMethod.class);
            int value = autoRunMethod.value();
            System.out.println(value);
        }
    }
}
