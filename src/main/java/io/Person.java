package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Description
 * @ClassName Person
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/07 17:20
 * @Version 1.0
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private String gender;
    private String[] others;

    public Person() {
    }

    public Person(String name, int age, String gender, String[] others) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.others = others;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", others=" + Arrays.toString(others) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOthers() {
        return others;
    }

    public void setOthers(String[] others) {
        this.others = others;
    }
}
