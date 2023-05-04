package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

/**
 * 使用当前类测试反射
 */
@AutoRunClass
public class Person {
    private String name = "张三";
    private int age = 18;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void show() {
        System.out.println("我是Person类的私有方法");
    }


    public void sayHello() {
        System.out.println(name + ":hello");
    }

    public void say(String info) {
        System.out.println(name + "说" + info);
    }

    @AutoRunMethod(2)
    public void sayHi() {
        System.out.println(name + ":hi");
    }

    public void sayGoodBye() {
        System.out.println(name + ":goodBye");
    }

    @AutoRunMethod(3)
    public void playGame() {
        System.out.println(name + ":打游戏");
    }

    @AutoRunMethod(4)
    public void watchTV() {
        System.out.println(name + ":看电视");
    }

    public void say(String info, int count) {
        for (; count > 0; count--) {
            System.out.println(name + "说" + info);
        }
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}