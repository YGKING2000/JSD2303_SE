package homework.day03.second;

/**
 * @Description
 * @ClassName User
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 13:01
 * @Version 1.0
 */
public class User {
    private int age;
    private String name;
    private String sex;

    public User(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
