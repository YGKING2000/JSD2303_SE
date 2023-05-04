package reflect.annotations;

import java.lang.reflect.Method;

/**
 * @Description
 * @ClassName ReflectDemo8
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 15:22
 * @Version 1.0
 */
public class ReflectDemo8 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Method method = cls.getDeclaredMethod("sayHello");
        System.out.println(method.isAnnotationPresent(AutoRunMethod.class));
    }
}
