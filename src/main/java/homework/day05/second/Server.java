package homework.day05.second;

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
 * @Date 2023/04/12 20:16
 * @Version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(20458);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                Thread thread = new Thread(handler);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
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
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String message = br.readLine();
                    if (message == null || "exit".equalsIgnoreCase(message)) {
                        System.out.println("客户端" + host + "已关闭!");
                        break;
                    }
                    System.out.println(host + ": " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
