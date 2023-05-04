package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description Map集合的遍历
 * @ClassName MapDemo2
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/17 16:12
 * @Version 1.0
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 108);
        map.put("数学", 111);
        map.put("英语", 119);
        map.put("物理", 120);
        map.put("化学", 125);
        System.out.println(map);

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.print(key + "  ");// 物理  数学  化学  语文  英语
        }
        System.out.println();

        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.print(value + "  ");// 120  111  125  108  119
        }
        System.out.println();

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry: entrySet) {
            System.out.print(entry + "  ");// 物理=120  数学=111  化学=125  语文=108  英语=119
        }
        System.out.println();

        map.forEach((k, v) -> System.out.print(k + "=" + v + "  "));// 物理=120  数学=111  化学=125  语文=108  英语=119
    }
}
