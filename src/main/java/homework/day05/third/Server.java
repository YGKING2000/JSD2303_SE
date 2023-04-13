package homework.day05.third;

import homework.day05.second.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @ClassName Server
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 21:04
 * @Version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("服务器启动成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + "已连接成功!");
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final String host;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String message = br.readLine();
                    if (message == null || "exit".equalsIgnoreCase(message)) {
                        System.out.println("客户端" + host + "已主动断开连接!\n");
                        break;
                    }
                    System.out.println(host + ":" + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
