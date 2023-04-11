package homework.day03.second;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Description 程序实现的是简易记事本工具
 * 程序启动后向pw.txt文件写内容,用户输入的每一行字符串都写入到文件中，单独输入exit时程序退出
 * @ClassName Test04
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/11 13:33
 * @Version 1.0
 */
public class Test04 {
    public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("pw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw,true);

		Scanner scanner = new Scanner(System.in);
		System.out.println("请开始输入内容");
		while(true) {
			String str = scanner.nextLine();
			if("exit".equals(str)) {
				break;
			}
			pw.println(str);
		}
        pw.close();
    }
}
