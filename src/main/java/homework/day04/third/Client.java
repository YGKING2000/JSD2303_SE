package homework.day04.third;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description Client
 * @ClassName Client
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 08:20
 * @Version 1.0
 */
public class Client {
    private Socket socket;

    public Client() {
        try {
            System.out.println("客户端正在连接服务器...");
            socket = new Socket("localhost", 8088);
            System.out.println("客户端成功连接服务器！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("请输入任意内容：");
                String message = scanner.nextLine();
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("客户端已关闭！");
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
