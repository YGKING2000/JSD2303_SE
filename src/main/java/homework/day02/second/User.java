package homework.day02.second;

import java.io.Serializable;

/**
 * @Description
 * @ClassName User
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/08 20:44
 * @Version 1.0
 */
public class User implements Serializable {
    private String name;
    private String pwd;
    private String gender;
    private int age;

    public User() {
    }

    public User(String name, String pwd, String gender, int age) {
        this.name = name;
        this.pwd = pwd;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
