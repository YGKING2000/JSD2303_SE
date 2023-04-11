# Java面试题

## 简答题

1. **JDK、JRE、JVM的区别：**
   - JDK：java开发工具包，是java的核心，包括：JRE+编译、运行等命令工具
   - JRE：java运行环境，是运行java程序所必须的环境集合，包括：JVM+java系统类库
   - JVM：java虚拟机，是java实现跨平台的最核心部分，能够运行java语言所开发的程序
2. **java的8种基本数据类型是什么？(简述java的8种基本数据类型）**
   - 8种基本数据类型包括：byte、short、int、long、float、double、boolean、char
     - byte：字节型，用于存储整数的，占用1个字节，范围-128到127
     - short：短整型，用于存储整数的，占用2个字节，范围-32768到32767
     - int：最常用的整型，用于存储整数的，占用4个字节，范围-2^31到2^31-1
     - long：长整型，用于存储较大的整数的，占用8个字节，范围-2^63到2^63-1
     - float：单精度浮点型，用于存储小数的，占用 4个字节，不能表示精确的值
     - double：双精度浮点型，最常用的存储小数的类型，占用8个字节，不能表示精确的值
     - boolean：布尔型，用于存储true或false，占用1个字节
     - char：字符型，采用Unicode字符编码格式，用于存储单个字符，占用2个字节
3. **switch中的case后可以使用哪些数据类型？**
   - 只能使用byte、short、int、char、String、枚举，其它类型都不允许

## 选择题

1. 下面程序运行的结果是（A）

   ```java
   int a,b;
   for(a=1,b=1;a<=100;a++){
       if(b>=10){
           break;
       }
       if(b%2==1){
           b+=2;
           continue;
       }
   }
   System.out.println(a); 
   ```

   A：6     B：5     C：7     D：8

2. 下面程序运行的结果为（A）

   ```java
   int x = 0;
   int y = 10;
   do{
       y--;
       ++x;
   }while(x<6);
   System.out.println(x+","+y);
   ```

   A：6,4     B：5,4     C：4,5     D：5,5
