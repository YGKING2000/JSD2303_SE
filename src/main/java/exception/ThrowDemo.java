package exception;

/**
 * @Description 异常的抛出
 * @ClassName ThrowDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 17:41
 * @Version 1.0
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person person = new Person();
        try {
            person.setAge(10000);
            System.out.println("此人年龄是" + person.getAge() + "岁");
        } catch (IllegalAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
