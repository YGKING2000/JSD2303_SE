package exception;

/**
 * @Description
 * @ClassName FinallyDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 15:49
 * @Version 1.0
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        String line = null;
        // String line = "";
        try {
            System.out.println(line.length());
            return;
        } catch (Exception e) {
            System.out.println("出错了");
        } finally {
            System.out.println("finally块代码执行了");
        }
        System.out.println("程序结束了");
    }
}
