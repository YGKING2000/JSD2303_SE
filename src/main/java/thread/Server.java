package thread;

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
 * @Date 2023/04/12 11:32
 * @Version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(8088);
            System.out.println("服务器成功启动!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        PrintWriter pw = null;
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
                System.out.println("客户端" + host + "连接成功!");

                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);

                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                pw = new PrintWriter(osw, true);
                synchronized (allOut) {
                    allOut.add(pw);
                }
                sendMessage(host + "上线了，当前人数" + allOut.size());

                while (true) {
                    // 读取客户端发送过来的消息
                    String message = br.readLine();
                    // 对客户端的消息进行校验
                    if (message == null || "exit".equalsIgnoreCase(message)) {
                        System.out.println("客户端" + host + "已主动断开连接！");
                        break;
                    }
                    sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                synchronized (allOut) {
                    allOut.remove(pw);
                }
                sendMessage(host + "下线了，当前人数为" + allOut.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*
         * @Description 将消息发送给所有客户端
         * @Return void
         * @Params []
         * @ParamsType []
         * @Author YGKING
         * @Date 2023/04/13 16:18:32
         */
        private void sendMessage(String message) {
            System.out.println(host + "说:" + message);
            // 将客户端发送过来的消息在回传给所有客户端
            synchronized(allOut) {
                for (PrintWriter printWriter : allOut) {
                    printWriter.println(host + "说:" + message);
                }
            }
        }
    }
}
