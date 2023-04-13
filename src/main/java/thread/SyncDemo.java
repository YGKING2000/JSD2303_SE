package thread;

import java.io.FileFilter;

/**
 * @Description
 * @ClassName SyncDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 09:20
 * @Version 1.0
 */
public class SyncDemo {
    public static void main(String[] args) {
        Table table = new Table();
        Thread thread = new Thread(() -> {
           while (true) {
               int beans = table.getBeans();
               Thread.yield();
               System.out.println(beans);
           }
        });
        Thread thread1 = new Thread(() -> {
            while (true) {
                int beans = table.getBeans();
                Thread.yield();
                System.out.println(beans);
            }
        });
        thread.start();
        thread1.start();
    }
}

class Table {
    private int beans = 20;

    public synchronized int getBeans() {
        if (beans == 0) {
            throw new RuntimeException();
        }
        Thread.yield();
        return beans--;
    }
}
