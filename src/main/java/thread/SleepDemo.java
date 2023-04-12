package thread;

import java.io.*;
import java.util.Scanner;

/**
 * @Description 暂停程序的执行
 * @ClassName SleepDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 15:31
 * @Version 1.0
 */
public class SleepDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入倒计时(秒)：");
        // long time = scanner.nextLong();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long time = 0;
        try {
            time = Long.parseLong(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (long i = time; i >= 0; i--) {
                if (time != 0) {
                    System.out.println("还剩" + time + "秒");
                } else {
                    System.out.println("时间到！");
                    break;
                }
                Thread.sleep(1000);
                time--;
            }
            /*while (time >= 0) {
                if (time != 0) {
                    System.out.println("还剩" + time + "秒");
                } else {
                    System.out.println("时间到！");
                    break;
                }
                Thread.sleep(1000);
                time--;
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
