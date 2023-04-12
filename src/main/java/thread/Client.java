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
            socket = new Socket("localhost", 8848);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        OutputStream out = null;
        try {
            out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("当前客户端已关闭！");
                    break;
                }
                pw.println(message);
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

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

}
