package reflect;

/**
 * @Description
 * @ClassName Father
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/19 08:29
 * @Version 1.0
 */
public class Father {
    public static final String str = "Father";
    public String name;

    public Father() {
    }

    public Father(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("Father:Say");
    }

    public static void main(String[] args) {
        Father father = new Father("23");
        Son son = new Son("3");
        System.out.println(Father.str);
        System.out.println(Son.str);
        System.out.println(father.str);
        System.out.println(son.str);
        System.out.println(((Father) new Son("3")).str);
        father.say();
        son.say();
        ((Father) son).say();


        String s = "csd.class.class";
        String s1 = s.replace('c', 'W');
        System.out.println(s);
        System.out.println(s1);
    }

}

class Son extends Father {
    public static final String str = "Son";

    public void say() {
        System.out.println("Son:Say");
    }

    public Son() {
    }

    public Son(String name) {
        super(name);
    }
}
