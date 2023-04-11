package exception;

/**
 * @Description 年龄非法异常
 * @ClassName IllegalAgeException
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 10:18
 * @Version 1.0
 */
public class IllegalAgeException extends Exception {
    public IllegalAgeException() {
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(Throwable cause) {
        super(cause);
    }

    public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
