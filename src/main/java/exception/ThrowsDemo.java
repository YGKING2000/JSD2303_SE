package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description
 * @ClassName ThrowsDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 09:23
 * @Version 1.0
 */
public class ThrowsDemo {
    public void doSome() throws IOException, AWTException {

    }
}

class SubClass extends ThrowDemo  {
    // 1.派生类的方法可以不抛出任何异常
    // public void doSome(){}
    // 2.派生类的方法可以抛出部分异常
    // public void doSome() throws IOException{}
    // 3.派生类的方法可以抛出超类方法所抛出异常的派生异常
    public void doSome() throws FileNotFoundException {}
}
