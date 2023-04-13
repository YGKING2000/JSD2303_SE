package thread;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @ClassName SyncDemo3
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 11:41
 * @Version 1.0
 */
public class SyncDemo3 {
    public static void main(String[] args) {
        Foo foo1 = new Foo();
        Foo foo2 = new Foo();
        new Thread(() -> foo1.doSome(), "foo1").start();
        new Thread(() -> foo2.doSome(), "foo2").start();
    }
}

class Foo {
    public static void doSome() {
        // 我们一般使用类名.class来指代当前类的类对象
        synchronized (Foo.class) {
            try {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + "正在执行doSome方法...");
                Thread.sleep(3000);
                System.out.println(thread.getName() + "执行doSome方法完毕!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
