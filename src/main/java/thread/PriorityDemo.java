package thread;

/**
 * @Description
 * @ClassName PriorityDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 15:18
 * @Version 1.0
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("min");
            }
        });
        Thread max = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("max");
            }
        });
        Thread norm = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("nor");
            }
        });
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        max.start();
        norm.start();
    }
}
