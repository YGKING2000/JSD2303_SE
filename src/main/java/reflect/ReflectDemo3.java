package reflect;

import java.lang.reflect.Constructor;

/**
 * @Description
 * @ClassName ReflectDemo3
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 09:03
 * @Version 1.0
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        // Constructor constructor = cls.getConstructor();
        // constructor.newInstance();

        // Constructor getConstructor(): 获取当前类的无参构造器
        Constructor constructor = cls.getConstructor(String.class);
        Object obj = constructor.newInstance("胡歌");
        System.out.println(obj);

        // Constructor getConstructor(): 获取当前类的指定参数列表的构造器
        Constructor constructor1 = cls.getConstructor(String.class, int.class);
        Object obj1 = constructor1.newInstance("刘亦菲", 17);
        System.out.println(obj1);
    }
}
