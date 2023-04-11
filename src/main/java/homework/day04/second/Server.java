package homework.day04.second;

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
 * @Date 2023/04/11 19:35
 * @Version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            System.out.println("服务器启动中...");
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            System.out.println("一个客户端正在连接中...");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接成功!");

            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                String message = br.readLine();
                if (message == null || "exit".equalsIgnoreCase(message)) {
                    System.out.println("服务器已关闭，请重新尝试!");
                    break;
                }
                System.out.println(message);
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
