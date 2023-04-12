package thread;

/**
 * @Description
 * @ClassName ThreadDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 10:16
 * @Version 1.0
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r1 = new MyRunnable1();
        Runnable r2 = new MyRunnable2();
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r2);
        t3.start();
        t4.start();
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我听见雨滴落在青青草地");
        }
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我听见远方钟声响起");
        }
    }
}
