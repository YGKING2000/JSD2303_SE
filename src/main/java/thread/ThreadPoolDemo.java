package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @ClassName ThreadPoolDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/23 11:53
 * @Version 1.0
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 1000; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread thread = Thread.currentThread();
                        System.out.println(thread.getName() + "正在执行一个任务...");
                        Thread.sleep(5000);
                        System.out.println(thread.getName() + "任务执行完毕!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.execute(runnable);
            System.out.println("交给线程池一个任务!");
        }
        // threadPool.shutdown();
        threadPool.shutdownNow();
        System.out.println("线程池关闭！");
    }
}
