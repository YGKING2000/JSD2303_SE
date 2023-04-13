package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @ClassName SimpleDateFormat
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 00:06
 * @Version 1.0
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        // 产生一个Date实例
        Date date = new Date();
        System.out.println(date);//
        // 产生一个formatter格式化的实例
        SimpleDateFormat formatter = new SimpleDateFormat();
        // 打印输出默认的格式
        System.out.println(formatter.format(date));// 23-4-13 上午12:09

        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");
        System.out.println(formatter2.format(date));// 2023年04月13日 星期四 00:09:23
        try {
            // 实例化一个指定的格式对象
            Date date2 = formatter2.parse("2008年08月08日 星期一 08:08:08");
            // 将指定的日期解析后格式化按指定的格式输出
            System.out.println(date2);// Fri Aug 08 08:08:08 CST 2008
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
