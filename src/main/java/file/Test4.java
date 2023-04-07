package file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Description 方法引用
 * @ClassName Test4
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/06 15:33
 * @Version 1.0
 */
public class Test4 {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            collection.add(random.nextInt(100));
        }
        collection.forEach(integer -> System.out.print(integer + " "));
        // every、reduce、some、find、filter
        System.out.println();
        Stream<Integer> collection1 = collection.stream().filter(integer -> integer > 50);
        // collection1.forEach(integer -> System.out.println(integer));
        collection1.forEach(System.out::println);
    }
}
