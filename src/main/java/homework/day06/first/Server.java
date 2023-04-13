package homework.day06.first;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @ClassName Server
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 16:56
 * @Version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(8088);
            System.out.println("服务器启动成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                new Thread(handler).start();
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

        private static final List<PrintWriter> allOut = new ArrayList<>();

        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                OutputStream out = socket.getOutputStream();
                pw = new PrintWriter(out, true);
                synchronized(allOut) {
                    allOut.add(pw);
                }
                sendMessage(host + "上线了，当前人数为" + allOut.size());
                while (true) {
                    String message = br.readLine();
                    if (message == null || "exit".equalsIgnoreCase(message)) {
                        break;
                    }
                    sendMessage(host + ":" + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                synchronized (allOut) {
                    allOut.remove(pw);
                }
                // 提示所有用户有用户下线了
                sendMessage(host + "下线了，当前人数为" + allOut.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*
         * @Description 给所有用户发信息的方法
         * @Return void
         * @Params [message]
         * @ParamsType [java.lang.String]
         * @Author YGKING
         * @Date 2023/04/13 17:28:57
         */
        private void sendMessage(String message) {
            System.out.println(message);
            synchronized (allOut) {
                for (PrintWriter p : allOut) {
                    p.println(message);
                }
            }
        }
    }
}
