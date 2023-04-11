package socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 11:27
 * @Version 1.0
 */
public class Client {
    /*
     * java.net.Socket 套接字：指的是两台设备之间通讯的端点
     * Socket封装了TCP协议的通讯细节，使用它可以通过网络与远端计算机进行TCP链接并基于两条流(输入与输出)与远端计算机通讯
     *
     * 构造方法：public Socket(String host, int port)
     * 创建套接字对象并将其连接到指定主机上的指定端口号，如果指定的host是null，则相当于指定地址为回送地址
     *
     * 回送地址：回送地址(127.x.x.x)是本机回送地址（LoopbackAddress），主要用于网络软件测试以及本地机进程间通信
     * 无论什么程序，一旦使用回送地址发送数据，立即返回，不进行任何网络传输
     */
    private Socket socket;

    // 构造方法
    public Client() {
        try {
            System.out.println("正在连接服务器...");
            socket = new Socket("localhost", 8088);
            System.out.println("服务器连接成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 让客户端开始工作的方法
    public void start() {

    }

    // 方法
    public static void main(String[] args) {
        // 创建一个客户端
        Client client = new Client();
        // 让客户端启动后开始运行
        client.start();
    }
}
