package thread;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Client
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 11:34
 * @Version 1.0
 */
public class Client {
    private Socket socket;

    public Client() {
        try {
            socket = new Socket("176.114.14.150", 8088);
            System.out.println("成功连接服务器!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            ServerHandler handler = new ServerHandler();
            Thread thread = new Thread(handler);
            thread.setDaemon(true);
            thread.start();

            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            PrintWriter pw = new PrintWriter(osw, true);

            // InputStream in = socket.getInputStream();
            // InputStreamReader isr = new InputStreamReader(in);
            // BufferedReader br = new BufferedReader(isr);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入任意内容:");
                String message = scanner.nextLine();
                pw.println(message);
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("当前客户端已关闭！");
                    break;
                }
                // message = br.readLine();
                // System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 进行4次挥手操作
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ServerHandler implements Runnable {
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String message = br.readLine();
                    if (message == null) break;
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

}
