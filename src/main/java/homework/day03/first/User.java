package homework.day03.first;

/**
 * @Description
 * @ClassName User
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 08:48
 * @Version 1.0
 */
public class User {
    private int age;
    private String name;
    private String gender;

    public User(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
