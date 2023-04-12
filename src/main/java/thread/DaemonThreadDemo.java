package thread;

/**
 * @Description
 * @ClassName DaemonThreadDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 16:56
 * @Version 1.0
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread("Rose") {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        sleep(1000);
                        System.out.println(getName() + ":Let me go!");
                    }
                    System.out.println("啊啊啊啊啊AAAAAaaaaa");
                    System.out.println("噗通！咕咕咕咕咕！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread jack = new Thread("Jack") {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                        System.out.println(getName() + ":You jump, I jump!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        rose.start();
        jack.setDaemon(true);
        jack.start();
    }
}
