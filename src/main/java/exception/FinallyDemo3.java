package exception;

/**
 * @Description
 * @ClassName FinallyDemo3
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/10 16:47
 * @Version 1.0
 */
public class FinallyDemo3 {
    public static void main(String[] args) {
        System.out.print(test("0") + ", " + test(null) + ", " + test(""));
        // 3, 3, 3
    }

    public static int test(String str) {
        try {
            return str.charAt(0) - '0';
        } catch (NullPointerException e) {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
