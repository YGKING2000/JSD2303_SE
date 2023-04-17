package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description HashMap的演示
 * @ClassName MapDemo
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/17 15:21
 * @Version 1.0
 */
public class MapDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list);

        Map<String, Integer> map = new HashMap<>();
        // Object put(<K, V>):
        Integer value = map.put("数学", 100);
        System.out.println("value:" + value);// null
        map.put("语文", 115);
        map.put("英语", 122);
        map.put("物理", 130);
        map.put("地理", 149);
        System.out.println(map);

        value = map.put("语文", 120);
        System.out.println("value:" + value);// 115

        value = map.get("数学");
        System.out.println("数学:" + value);// 100
        value = map.get("体育");
        System.out.println("体育:" + value);// null

        int size = map.size();
        System.out.println("size" + size);// 5

        boolean ck = map.containsKey("语文");
        System.out.println("是否包含key语文:" + ck);// true
        ck = map.containsKey("体育");
        System.out.println("是否包含key值体育:" + ck);// false

        ck = map.containsValue(120);
        System.out.println("是否包含key值120:" + ck);// true
        ck = map.containsValue(119);
        System.out.println("是否包含value值119:" + ck);// false

        System.out.println(map);// {物理=130, 数学=100, 语文=120, 英语=122, 地理=149}
        value = map.remove("物理");
        System.out.println(map);// {数学=100, 语文=120, 英语=122, 地理=149}
        System.out.println("value:" + value);// 130
    }
}
