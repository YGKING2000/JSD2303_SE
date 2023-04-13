package thread;

/**
 * @Description
 * @ClassName SyncDemo4
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 14:13
 * @Version 1.0
 */
public class SyncDemo4 {
    public static void main(String[] args) {
        Boo boo = new Boo();
        new Thread(boo::methodA, "t1").start();
        new Thread(boo::methodB, "t2").start();
    }
}

class Boo {
    public synchronized void methodA() {
        try {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "正在执行A方法...");
            Thread.sleep(3000);
            System.out.println(thread.getName() + "执行A方法完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // public synchronized void methodB() {
    public void methodB() {
        synchronized (this) {
            try {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + "正在执行B方法...");
                Thread.sleep(3000);
                System.out.println(thread.getName() + "执行B方法完毕!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
