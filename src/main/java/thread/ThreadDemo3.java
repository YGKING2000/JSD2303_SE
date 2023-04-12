package thread;

/**
 * @Description
 * @ClassName ThreadDemo3
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 10:27
 * @Version 1.0
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("红红火火恍恍惚惚");
                }
            }
        };

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("红红火火恍恍惚惚");
                }
            }
        };

        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("哈哈哈");
            }
        };
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}
