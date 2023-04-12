package thread;

/**
 * @Description
 * @ClassName ThreadDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 09:31
 * @Version 1.0
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我听见雨滴落在青青草地");
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我听见远方钟声响起");
        }
    }
}


