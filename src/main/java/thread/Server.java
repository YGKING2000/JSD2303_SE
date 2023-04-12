package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @ClassName Server
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 11:32
 * @Version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(8848);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                // 创建一个Runnable的派生类对象
                ClientHandler handler = new ClientHandler(socket);
                // 创建一个线程
                Thread thread = new Thread(handler);
                // 启动线程
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private String host;

        public String getHost() {
            return host;
        }

        public ClientHandler(Socket socket) {
            this.socket = socket;
            // Socket类实例方法
            // InetAddress getInetAddress(): 返回套接字所连接的地址
            // InetAddress类实例方法
            // String getHostAddress(): 返回文本显示中的IP地址字符串
            this.host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            InputStream in = null;
            try {
                in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String message = br.readLine();
                    if (message == null || "exit".equalsIgnoreCase(message)) {
                        System.out.println("当前服务器已关闭！");
                        break;
                    }
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
