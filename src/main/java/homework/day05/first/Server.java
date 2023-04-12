package homework.day05.first;

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
 * @Date 2023/04/12 18:56
 * @Version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                SocketHandler handler = new SocketHandler(socket);
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

    private class SocketHandler implements Runnable {
        private Socket socket;
        private String host;

        public SocketHandler(Socket socket) {
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
                        System.out.println("客户端断连...");
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
