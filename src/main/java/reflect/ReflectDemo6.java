package reflect;

import java.lang.reflect.Method;

/**
 * @Description
 * @ClassName ReflectDemo6
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 10:27
 * @Version 1.0
 */
public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        // Method
        // Method method = cls.getMethod("show");
        Method method = cls.getDeclaredMethod("show");
        method.setAccessible(true);
        method.invoke(obj);
        method.setAccessible(false);
    }
}
