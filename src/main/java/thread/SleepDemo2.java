package thread;

/**
 * @Description
 * @ClassName SleepDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 16:08
 * @Version 1.0
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread("林永健") {
            @Override
            public void run() {
                System.out.println(getName() + "正在睡美容觉...");
                try {
                    sleep(100000000);
                } catch (InterruptedException e) {
                    System.out.println("干嘛呢！干嘛呢！干嘛呢！");
                }
                System.out.println("都给我整破相了！");
            }
        };

        Thread huang = new Thread("黄宏") {
            @Override
            public void run() {
                try {
                    for (int i = 5; i > 0; i--) {
                        sleep(1000);
                        System.out.println(getName() + ": 80！");
                    }
                    sleep(1000);
                    System.out.println("大哥，好了！");
                    sleep(1000);
                    System.out.println("咣当！");
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lin.interrupt();
            }
        };
        lin.start();
        huang.start();
    }
}
