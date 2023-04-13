package homework.day06.second;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @ClassName Sever
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 19:11
 * @Version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            System.out.println("服务器正在启动...");
            serverSocket = new ServerSocket(10000);
            System.out.println("服务器启动成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
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
                OutputStream out =  socket.getOutputStream();
                pw = new PrintWriter(out, true);
                synchronized (allOut) {
                    allOut.add(pw);
                }
                sendMessage(host + "上线了，当前人数为" + allOut.size());
                
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String message = br.readLine();
                    if (message == null) {
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
                sendMessage(host + "下线了，当前人数为" + allOut.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        private void sendMessage(String message) {
            System.out.println(message);
            for (PrintWriter pw : allOut) {
                pw.println(message);
            }
        }
    }
}
