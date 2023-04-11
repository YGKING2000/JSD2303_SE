package exception;

/**
 * @Description
 * @ClassName Person
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 17:40
 * @Version 1.0
 */
public class Person {
    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if (age > 120 || age < 0) {
            throw new IllegalAgeException("年龄超出了范围!");
        }
        this.age = age;
    }
}
