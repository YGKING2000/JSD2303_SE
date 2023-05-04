package reflect;

import reflect.annotations.AutoRunClass;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @Description
 * @ClassName Test3
 * @Author YGKING e-mail:hrd18960706057@163.com
 * @Date 2023/04/21 14:45
 * @Version 1.0
 */
@AutoRunClass
public class Test3 {
    public static void main(String[] args) throws Exception {
        Package pack = Test3.class.getPackage();

        ArrayList<Object> list = new ArrayList<>();
        File dir = new File(Objects.requireNonNull(Test3.class.getResource(".")).toURI());
        File[] files = dir.listFiles(file -> file.getName().endsWith(".class"));
        for (File file : files) {
            String className = file.getName().replace(".class", "");
            Class cls = Class.forName(pack.getName() + "." + className);
            if (cls.isAnnotationPresent(AutoRunClass.class)) {
                list.add(cls.newInstance());
            }
        }
        System.out.println(list);
    }
}
