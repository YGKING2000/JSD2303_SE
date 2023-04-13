package homework.day06.second;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Client
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 19:45
 * @Version 1.0
 */
public class Client {
    private Socket socket;

    public Client() {
        try {
            System.out.println("正在连接服务器中...");
            socket = new Socket("176.114.14.150", 10000);
            System.out.println("连接服务器成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            ServerClient handler = new ServerClient();
            Thread thread = new Thread(handler);
            thread.setDaemon(true);
            thread.start();

            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                if (message == null || "exit".equalsIgnoreCase(message)) {
                    System.out.println("当前客户端已关闭!");
                    break;
                }
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ServerClient implements Runnable {
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String message = br.readLine();
                    if (message == null) {
                        break;
                    }
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
