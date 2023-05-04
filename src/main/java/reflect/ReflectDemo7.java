package reflect;

import reflect.annotations.AutoRunClass;

/**
 * @Description
 * @ClassName ReflectDemo7
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 14:23
 * @Version 1.0
 */
public class ReflectDemo7 {
    public static void main(String[] args) {
        Class cls = Person.class;
        boolean mark = cls.isAnnotationPresent(AutoRunClass.class);
        System.out.println(mark);// true
    }
}
