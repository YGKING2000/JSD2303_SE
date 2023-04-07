package homework.day02.first;

import java.io.Serializable;

/**
 * @Description
 * @ClassName Person
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 20:43
 * @Version 1.0
 */
public class User implements Serializable {
    private String name;
    private String pwd;
    private String nick;
    private int age;

    public User() {
    }

    public User(String name, String pwd, String nick, int age) {
        this.name = name;
        this.pwd = pwd;
        this.nick = nick;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nick='" + nick + '\'' +
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
