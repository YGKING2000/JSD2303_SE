package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description 调用一个对象的所有公开方法
 * @ClassName Test1
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 10:34
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();
        // Method[] getDeclaredMethods(): 获取当前类的所有方法(包括私有方法)
        Method[] methods = cls.getDeclaredMethods();
        // int getParameterCount(): 获取方法的参数个数
        for (Method method : methods) {
            int count = method.getParameterCount();
            // int getModifiers(): 获取方法的权限修饰符所对应的int值
            if (count == 0 && method.getModifiers() == Modifier.PUBLIC) {
                method.invoke(obj);
            }
        }
    }
}
