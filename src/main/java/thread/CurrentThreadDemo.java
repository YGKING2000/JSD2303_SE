package thread;

/**
 * @Description
 * @ClassName CurrentThreadDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 10:47
 * @Version 1.0
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println("main:" + main);// main:Thread[main,5,main]
        doSome();// thread:Thread[main,5,main]

        Thread thread = new Thread(CurrentThreadDemo::doSome);
        thread.start();// thread:Thread[Thread-0,5,main]
    }

    public static void doSome() {
        Thread thread = Thread.currentThread();
        System.out.println("thread:" + thread);
    }
}
