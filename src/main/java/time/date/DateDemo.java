package time.date;

import java.util.Date;

/**
 * @Description
 * @ClassName DateDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 19:48
 * @Version 1.0
 */
public class DateDemo {
    public static void main(String[] args) {
        Date time1 = new Date();
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += i;
        }
        Date time2 = new Date();

        long mills1 = time1.getTime();
        long mills2 = time2.getTime();
        System.out.println(mills1);
        System.out.println(mills2);

        System.out.println(time1);// 1681300997 372
        System.out.println(time2);// 1681300997 660

        System.out.println(time1.after(time2));// false
        System.out.println(time1.before(time2));// true
    }
}
