package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description 服务器
 * @ClassName Server
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 11:28
 * @Version 1.0
 */
public class Server {
    /*
     * java.net.ServerSocket: 这个类实现了服务器套接字，该对象等待通过网络的请求
     *
     * 构造方法: public ServerSocket(int port)
     * 使用该构造方法在创建ServerSocket对象时，就可以将其绑定到一个指定的端口号上，参数port就是端口号
     *
     * 成员方法: public Socket accept()
     * 侦听并接受连接，返回一个新的Socket对象，用于和客户端实现通信，该方法会一直阻塞直到建立连接
     *
     * 注意事项: 服务器端开启了之后，才能给客户端返回信息
     */
    private ServerSocket serverSocket;

    public Server() {
        try {
            System.out.println("正在启动服务器...");
            serverSocket = new ServerSocket(8848);
            System.out.println("服务器启动成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                System.out.println("一个客户端正在连接...");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接成功！");
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(line)) {
                        System.out.println("服务器已关闭！");
                        break;
                    }
                    System.out.println("客户端说：" + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
