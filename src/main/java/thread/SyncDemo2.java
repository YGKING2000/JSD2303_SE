package thread;

/**
 * @Description
 * @ClassName SyncDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 10:18
 * @Version 1.0
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Shop shop1 = new Shop();
        Thread thread = new Thread(shop::buy, "胡歌");
        Thread thread1 = new Thread(shop1::buy, "刘亦菲");
        thread.start();
        thread1.start();
    }
}

class Shop {
    public void buy() {
        try {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "正在挑衣服...");
            Thread.sleep(3000);

            synchronized (this) {
                System.out.println(thread.getName() + "开始试衣服...");
                Thread.sleep(3000);
            }

            System.out.println(thread.getName() + "已结账离开!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}