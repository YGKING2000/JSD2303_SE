package thread;

/**
 * @Description 获取线程相关信息
 * @ClassName ThreadInfoDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 14:33
 * @Version 1.0
 */
public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        // long getId(): 返回此线程的标识符
        long id = thread.getId();
        System.out.println("id: " + id);// id: 1
        // String getName(): 返回此线程的名称
        String name = thread.getName();
        System.out.println("当前线程名称是: " + name);// 当前线程名称是: main
        // boolean isAlive(): 测试这个线程是否活着
        boolean isAlive = thread.isAlive();
        System.out.println("当前进程还活着吗: " + isAlive);// 当前进程还活着吗: true
        // boolean isDaemon(): 测试这个线程是否是守护线程
        boolean isDaemon = thread.isDaemon();
        System.out.println("当前进程是守护进程吗: " + isDaemon);// 当前进程是守护进程吗: false
        // boolean isInterrupted(): 测试当前线程是否中断
        boolean isInterrupted = thread.isInterrupted();
        System.out.println("当前进程是否被中断: " + isInterrupted);// 当前进程是否被中断: false
    }
}
