package exception;

/**
 * @Description try...catch...捕获处理异常的演示
 * @ClassName TryCatchDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 15:11
 * @Version 1.0
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始...");
        // String line = null;
        // String line = "";
        String line = "1234abc";
        try {
            System.out.println(line.length());
            System.out.println(line.charAt(0));
            System.out.println(Integer.parseInt(line));
        // } catch (NullPointerException e) {
        //     System.out.println("出现了空指针异常，并且已经解决了！");
        // } catch (StringIndexOutOfBoundsException e) {
        //     System.out.println("出现了字符串索引越界异常，并且已经解决了！");
        // }
        } catch (NullPointerException | StringIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("程序出现了空指针或字符串索引越界或数字格式异常，不过已经解决了!");
        } catch (Exception e) {
            System.out.println("反正就是出现了个错误!");
        }
        System.out.println("程序结束...");
    }
}
