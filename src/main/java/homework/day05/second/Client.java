package homework.day05.second;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @ClassName Client
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/12 20:42
 * @Version 1.0
 */
public class Client {
    private Socket socket;

    public Client() {
        try {
            socket = new Socket("localhost", 20458);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            PrintWriter pw = new PrintWriter(osw, true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("请输入任意内容: ");
                String message = scanner.nextLine();
                if (message == null || "exit".equalsIgnoreCase(message)) {
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
