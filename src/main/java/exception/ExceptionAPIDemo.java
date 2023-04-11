package exception;

/**
 * @Description
 * @ClassName ExceptionAPIDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 09:49
 * @Version 1.0
 */
public class ExceptionAPIDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            String s = "123abc";
            System.out.println(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            e.printStackTrace();// 将异常信息全部在控制台输出
            String message = e.getMessage();// 获取异常的出现原因
            System.out.println(message);
        }
        System.out.println("程序结束了");
    }
}
