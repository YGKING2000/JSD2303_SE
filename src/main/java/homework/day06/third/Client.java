package homework.day06.third;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Client
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/13 20:53
 * @Version 1.0
 */
public class Client {
    private Socket socket;

    public Client() {
        try {
            socket = new Socket("localhost", 9527);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        try {
            Thread thread = new Thread(new ServerHandler());
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
                pw.println(message);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
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
