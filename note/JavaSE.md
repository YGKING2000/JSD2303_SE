# JavaSE

## 一、File类

### 1.1 引入

1. `File`是位于`Java.io`包下的一个类，每一个实例对象用于表示一个文件或目录的

2. 使用`File`类创建的对象可以:
   - 访问文件或目录的属性
   - 创建/删除文件或目录
   - 访问一个目录中的所有子项
   - `File`不能访问文件里的数据

3. `File`类有两个常用的构造方法：`File(String pathName)`和`File(File parent, String pathName)`

```java
// 1.File(String pathName)：根据给定的路径创建File对象
File file = new File("./demo.txt");
// 2.File(File parent, String fileName)：parent表示的想要创建文件的目录对象，fileName则是文件名称
File dir = new File("./test");
File file1 = new File(dir, "demo.txt");
```

**注意事项：**

- 绝对路径: 从系统定义的根目录开始，
  - 优点：清晰明了
  - 缺点：不利于跨平台
- 相对路径: 从运行环境定义的路径开始
  - 优点：跨平台性好
  - 缺点：路径定义模糊，需要视环境而定

- `./`表示当前项目的目录，不同的运行环境定位不同，在IDEA中执行`Java`程序时，`./`表示当前项目目录

- 在相对路径中`./`是可以忽略不写的，默认就是从`./`开始

### 1.2 常用方法

1. **普通方法**

> - **String getName()：**返回当前`File`对象表示的文件或目录的名字
> - **long length()：**返回当前`File`对象表示的文件的长度，单位是字节
> - **boolean canRead()：**返回当前`File`对象表示的文件或目录是否可读
> - **boolean canWrite()：**返回当前`File`对象表示的文件或目录是否可写
> - **boolean isHidden()：**返回当前`File`对象表示的文件或目录是否被隐藏
> - **boolean exists()：**判断当前`File`对象表示的文件或目录是否已经存在
> - **boolean isFile()：**判断当前`File`对象表达的是否为一个真实存在的文件
> - **boolean isDirectory()：**判断当前`File`对象表达的是否为一个真实存在的目录
>
> ```java
> // 创建File类的对象有两种方式，下面这是绝对路径写法
> // File file = new File("C:/Users/YGKING/IdeaProjects/JSD2303_SE/demo.txt");
> // 下面这是相对路径的写法
> File file = new File("./demo.txt");
> // 1.String getName(): 获取文件名称
> String name = file.getName();
> System.out.println(name);// demo.txt
> 
> // 2.long length(): 获取当前文件内容的大小，单位是字节(byte)
> long length = file.length();
> System.out.println("占用字节数为:" + length);// 占用字节数为:6
> 
> // 3.boolean canRead(): 文件是否可读
> boolean cr = file.canRead();
> System.out.println(cr);// true
> 
> // 4.boolean canWrite(): 文件是否可写
> boolean cw = file.canWrite();
> System.out.println(cw);// true
> 
> // 5.boolean isHidden(): 文件是否被隐藏
> boolean ih = file.isHidden();
> System.out.println(ih);// false
> 
> // 6.boolean exists(): 判断文件或者目录是否已存在
> boolean exist = file.exists();
> if (exist) {
>     System.out.println("该文件已存在");
> } else {
>     System.out.println("文件不存在");
> }
> ```
>
> **注意事项：**

2. **进阶方法**

> - **boolean createNewFile()：**在当前`File`表示的路径下将**`文件`**创建出来，如果指定的文件不存在并成功创建，则返回`true`；如果指定的文件已经存在，则返回 `false`
>
> ```java
> // 1.创建一个File类的对象file
> File file = new File("./test.txt");
> // 2.创建这个文件
> boolean flag = file.createNewFile();
> if (flag) {
>     System.out.println("创建成功");
> } else {
>     System.out.println("文件已存在");
> }
> ```
>
> - **boolean delete()：**删除当前`File`对象表示的**`文件`**或者**`目录`**，当且仅当文件或者目录存在并成功删除时才返回`true`，否则均返回`false`
> - **注意事项：**当且仅当**`目录为空`**时，才能删除成功
>
> ```java
> // 删除文件
> File file = new File("test.txt");
> System.out.println(file.delete());
> 
> // 删除目录
> File file1 = new File("test");
> System.out.println(file1.delete());
> ```
>
> - **boolean mkdir()：**将当前`File`表示的**`目录`**创建出来，该方法要求当前`File`表示的目录所在的父目录必须存在，否则创建失败，当且仅当成功创建**`目录`**时，返回 `true`；否则返回 `false`
>
> ```java
> File dir = new File("demo");
> if (!dir.exists()) {
>     if (dir.mkdir()) {
>         System.out.println("文件夹创建成功");
>     } else {
>         System.out.println("文件创建失败");
>     }
> } else {
>     System.out.println("创建失败，该目录已存在");
> }
> ```
>
> - **boolean mkdirs()：**创建当前`File`对象表示的目录，并会**自动创建所有不存在的父目录**，实际开发中推荐用该方法创建目录
>
>   当且仅当已创建目录以及所有必需的父目录时，返回`true`；否则返回 `false`，
>
> ```java
> File dir = new File("a/b/c/d/e/f/g");
> if (dir.exists()) {
>     System.out.println("该目录已存在");
> } else {
>     if (dir.mkdirs()) {
>         System.out.println("创建成功");
>     } else {
>         System.out.println("创建失败");
>     }
> }
> ```
>
> - **File[] listFiles()：**获取当前`File`对象表示的目录中的所有子项，返回的数组中每个`File`对象表示该目录中的一个子项
> - **File[] listFiles(FileFilter filter)：**获取当前`File`对象表示的目录中的**`符合过滤器条件的子项`**
>
> ```java
> File dir = new File(".");
> if (dir.isDirectory()) {
>     File[] files = dir.listFiles();
>     if (files != null) {
>         System.out.println("一共有" + files.length + "个子项");
>         for (File file : files) {
>             System.out.println(file.getName());
>         }
>     }
> } else {
>     System.out.println("当前指向的不是一个文件夹");
> }
> 
> File dir = new File(".");
> if (dir.isDirectory()) {
>     File[] files = dir.listFiles(file -> file.getName().contains("a"));
>     if (files != null) {
>         for (File file : files) {
>             System.out.println(file.getName());
>         }
>     }
> }
> ```
>

## 二、I/O流

### 重点

#### 1.各种流的构造器特点

##### 文件输出流

```
FileOutputStream(File file)
创建文件输出流以写入由指定的 File对象表示的文件 
FileOutputStream(File file, boolean append)
创建文件输出流以写入由指定的 File对象表示的文件
FileOutputStream(String name)
创建文件输出流以指定的名称写入文件
FileOutputStream(String name, boolean append)
创建文件输出流以指定的名称写入文件
```

##### 文件输入流

```
FileInputStream(File file)
通过打开与实际文件的连接创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名 
FileInputStream(String name)
通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名
```

##### 缓冲输出流

```
BufferedOutputStream(OutputStream out)
创建一个新的缓冲输出流，以将数据写入指定的底层输出流
BufferedOutputStream(OutputStream out, int size)
创建一个新的缓冲输出流，以便以指定的缓冲区大小将数据写入指定的底层输出流
```

##### 缓冲输入流

```
BufferedInputStream(InputStream in)
创建一个 BufferedInputStream并保存其参数，输入流in，供以后使用
BufferedInputStream(InputStream in, int size)
创建 BufferedInputStream具有指定缓冲区大小，并保存其参数，输入流in，供以后使用
```

##### 对象输出流

```
ObjectOutputStream(OutputStream out) 
创建一个写入指定的OutputStream的ObjectOutputStream
```

##### 对象输入流

```
ObjectInputStream(InputStream in) 
创建从指定的InputStream读取的ObjectInputStream
```

##### 转换输出流

```
OutputStreamWriter(OutputStream out)
创建一个使用默认字符编码的OutputStreamWriter
OutputStreamWriter(OutputStream out, Charset cs)
创建一个使用给定字符集的OutputStreamWriter  
OutputStreamWriter(OutputStream out, String charsetName)
创建一个使用命名字符集的OutputStreamWriter
```

##### 转换输入流

```
InputStreamReader(InputStream in)
创建一个使用默认字符集的InputStreamReader
InputStreamReader(InputStream in, Charset cs)
创建一个使用给定字符集的InputStreamReader
创建一个使用给定字符集解码器的InputStreamReader 
InputStreamReader(InputStream in, String charsetName)
```

##### 缓冲输出字符流

```
PrintWriter(File file)
使用指定的文件创建一个新的PrintWriter，而不需要自动的线路刷新
PrintWriter(File file, String csn)
使用指定的文件和字符集创建一个新的PrintWriter，而不需要自动进行线条刷新

PrintWriter(OutputStream out)
从现有的OutputStream创建一个新的PrintWriter，而不需要自动线路刷新
PrintWriter(OutputStream out, boolean autoFlush)
从现有的OutputStream创建一个新的PrintWriter

PrintWriter(String fileName)
使用指定的文件名创建一个新的PrintWriter，而不需要自动执行行刷新
PrintWriter(String fileName, String csn)
使用指定的文件名和字符集创建一个新的PrintWriter，而不需要自动线路刷新

PrintWriter(Writer out)
创建一个新的PrintWriter，没有自动线冲洗
PrintWriter(Writer out, boolean autoFlush)
创建一个新的PrintWriter

BufferedWriter(Writer out) 
创建使用默认大小的输出缓冲区的缓冲字符输出流。  
BufferedWriter(Writer out, int size) 
创建一个新的缓冲字符输出流，使用给定大小的输出缓冲区 
```

##### 缓冲输入字符流

```
BufferedReader(Reader in)
创建使用默认大小的输入缓冲区的缓冲字符输入流
BufferedReader(Reader in, int size)
创建使用指定大小的输入缓冲区的缓冲字符输入流
```



### 2.1 引入

- `I/O `这里的`I`和`O`指的是输入与输出，这里的输入与输出是针对于程序的，而不是用户的输入输出
  - 输入：`Input`用来读取数据的，输入流的顶级超类是`java.io.InputStream`
  - 输出：`Output`用来写出数据的，输出流的顶级超类是`java.io.OutputStream`

- `I/O`主要分为**`字节流`**和**`处理流`**
- 字节流：又称为**`低级流`**
    - 特点：直接链接程序与另一端的"管道"，是真实读写数据的流
    - IO一定是建立在字节流的基础上进行的
    - 文件流就是典型的字节流(低级流)
  
- 处理流：又称为**`高级流`**
    - 特点：不能独立存在，必须链接在其他流上
    - 当数据经过当前高级流时可以对数据进行某种加工操作，来简化我们的同等操作
    - 实际开发中我们经常`串联`一组高级流最终到某个低级流上，使读写数据以流水线式的加工处理完成，这一操作也被称为使**`流的链接`**，**`流链接`**也是`JAVA I/O`的精髓所在

**注意事项：**

- **`close()`和`flush()`方法具有传递性**

- **所有的流在开启后，最好都手动关闭**
- **在关闭流时，输入流与输出流需要分开单独关闭**
- **当有多个流存在时，只需要关闭一个流就能将整个输入流或者输出流关闭**

### 2.2 文件流（字节流）

**`文件流`**是用来链接我们的程序与文件之间的**`管道`**，用来读写文件数据的流，文件流又分为

- 文件输入流`java.io.FileInputStream`：读取文件数据的流
- 文件输出流`java.io.FileOutputStream`：写出文件数据的流

**注意事项：**文件流是继承自`InputStream`和`OutputStream`

#### 2.2.1 文件输出流

**`java.io.FileOutputStream`**使用文件输出流向文件中写出数据，以下是其常用的4种构造器，后两种为追加模式

**注意事项：**当调用**`文件输出流`**的**`构造器`**创建文件与程序之间的管道时，分为**`追加模式`**和**`覆盖模式`**

1. **覆盖模式：**当文件流创建时发现指定的文件已经存在了，那么会将该文件内容清空，然后写出新的数据

```java
// 1.FileOutputStream(String path):覆盖模式
// 创建文件输出流对指定的path路径表示的文件进行写操作，如果该文件不存在则将其创建出来
FileOutputStream fos = new FileOutputStream("fos.dat");
    
// 2.FileOutputStream(File file):覆盖模式
// 创建文件输出流对指定的File对象表示的文件进行写操作，如果该文件不存在则将其创建出来
File file = new File("fos.dat");
FileOutputStream fos2 = new FileOutputStream(file);
```

2. **追加模式：**当文件流创建时发现指定的文件已经存在了，那么文件中的数据会保留，通过该流新写出的数据会被陆续的追加到文件中

```java
// 3.FileOutputStream(String path, boolean append):追加模式
// 创建文件输出流对指定的path路径表示的文件进行写操作，如果该文件不存在则将其创建出来
FileOutputStream fos = new FileOutputStream("fos.dat");
    
// 4.FileOutputStream(File file, boolean append):追加模式
// 创建文件输出流对指定的File对象表示的文件进行写操作，如果该文件不存在则将其创建出来
File file = new File("fos.dat");
FileOutputStream fos2 = new FileOutputStream(file);
```

**常用方法：**

> - **void write(int b)：**会将给定的`int`值对应的二进制的`最低8位`写出文件中，前面的`24位`则直接舍弃
> ```java
> System.out.println(file.length());// 0
> // 实际上这里将"01111111 11111111 1111111 11111111"的最低8位"11111111"存储进了文件中
> fos.write(2147483647);
> System.out.println(file.length());// 1
> fos.write(6);
> fos.close();
> System.out.println(file.length());// 2
> ```
>
> - **void write(byte[] b)：**将给定的**`byte`**数组直接写出文件中，因为减少了写出次数，所以效率较高
> - **void write(byte[] b, int off, int length)：**将**`byte`**数组**`b`**中从**`off`**作为数组起始位置，将数组中**`length`**个元素写出文件
>
> ```java
> // 文件复制案例
> FileInputStream fis = new FileInputStream(file);
> FileOutputStream fos = new FileOutputStream("ikun1.jpg");
> // 数组长度定义为1024(byte)*10，表示一次性读取的数据为10kb
> byte[] data = new byte[1024 * 10];
> while (true) {
>     int length = fis.read(data);
>     if (length == -1) {
>         break;
>     } else {
>         // fos.write(data);
>         fos.write(data, 0, length);
>     }
> }
> fis.close();
> fos.close();
> ```

#### 2.2.2 文件输入流

**`java.io.FileInputStream`**使用文件输入流向从文件中读取数据，以下是其常用的两个构造器：

```java
// 1.FileInputStream(String path)
// 基于给定的路径对应的文件创建文件输入流
FileInputStream fis = new FileInputStream("fis.txt");
    
// 2.FileInputStream(File file)
// 基于给定的File对象所表示的文件创建文件输入流
File file = new File("fis.txt");
FileInputStream fis2 = new FileInputStream(file);
```

**常用方法：**

> - **int read()：**从文件中读取1个字节的数据，
>
> ```java
> FileInputStream fis = new FileInputStream("fos.dat");
> // 实际上读取出来数据只有1个字节，只不过在返回返回值时，在方法内部会将其转换成int型
> int num = fis.read();
> System.out.println(num);// 0
> num = fis.read();
> System.out.println(num);// 1
> num = fis.read();
> System.out.println(num);// 255
> num = fis.read();
> System.out.println(num);// -1,当已经访问到文件末尾时，后面没有数据时返回-1
> ```
>
> - **int read(byte[] b)：**一次性读取指定**`byte`**数组长度的数据，并将数据装进数组**`b`**中，然后返回这次读取数据的**`字节数`**，如果当前文件未被读取的数据字节数不够了，则返回值的大小会比给定的数组**`b`**的长度小
>
> ```java
> File file = new File("ikun.jpg");
> FileInputStream fis = new FileInputStream(file);
> FileOutputStream fos = new FileOutputStream("ikun1.jpg");
> // 数组长度定义为1024(byte)*10，表示一次性读取的数据为10kb
> byte[] data = new byte[1024 * 10];
> long start = System.currentTimeMillis();
> while (true) {
>     int length = fis.read(data);
>     if (length == -1) {
>         break;
>     } else {
>         // fos.write(data);
>         fos.write(data, 0, length);
>     }
> }
> fis.close();
> fos.close();
> ```
>

### 2.3 缓冲流（字节流）

缓冲流分为`输出流`和`输入流`，是在包`java.io.BufferedInputStream`和`BufferedOutputStream`下，

- 其主要作用是在流链接中**`加快读写效率`**
- 通常缓冲流是`最终链接`在`字节流`上的`处理流`
- 通常是其他高级流处理完数据后，最后由缓冲流做最后的处理以达到加快读写的效果

#### 2.3.1 缓冲输出流

在**`缓冲输出流`**内部定义了一个**`byte[]数组`**，这个数组又称为**`缓冲区`**，该数组的长度默认为`8192(8192字节=8192b=8kb)`，**`缓冲输出流`**在写出数据时**`总是以块写出数据`**来保证写出效率，`缓冲输出流`提供了多种构造器，可以自行指定`缓冲区`大小

```java
// BufferedOutputStream(OutputStream out)
// 实例化一个缓冲字节输出流并链接在指定的字节输出流上，默认缓冲区大小8kb(内部维护的byte[] buf数组长度8192)

// BufferedOutputStream(OutputStream out, int size)
// 实例化一个指定缓冲区大小的缓冲字节输出流并链接在指定的字节输出流上
```

#### 2.3.2 缓冲输入流

在**`缓冲输入流`**内部定义了一个**`byte[]数组`**，这个数组又称为**`缓冲区`**，该数组的长度默认为`8192(8192字节=8192b=8kb)`，**`缓冲输入流`**在读取数据时**`总是以块读取数据`**来保证读取效率，`缓冲输入流`提供了多种构造器，可以自行指定`缓冲区`大小

```java
// BufferedInputStream(InputStream in)
// 实例化一个缓冲字节输入流并链接在指定的字节输入流上。默认缓冲区大小8kb(内部维护的byte[] buf数组长度8192)

// BufferedInputStream(InputStream in, int size)
// 实例化一个指定缓冲区大小的缓冲字节输入流并链接在指定的字节输入流上
```

#### 2.3.3 文件的复制

```java
FileInputStream fis = new FileInputStream("image.png");
FileOutputStream fos = new FileOutputStream("image1.png");

BufferedInputStream bis = new BufferedInputStream(fis);
BufferedOutputStream bos = new BufferedOutputStream(fos);

long start = System.currentTimeMillis();
int data;
while ((data = bis.read()) != -1) {
    bos.write(data);
}

long end = System.currentTimeMillis();
System.out.println("耗时" + (end - start) + "ms");// 耗时83ms

// 关闭缓冲输入流和输出流
bis.close();
bos.close();
```

#### 2.3.4 flush方法

由于**`缓冲输出流`**会将写出的数据**`装满`**内部缓冲区(默认8kb的`byte`数组)后，才会进行一次真实的写出操作

如果数据的长度不够`8kb`时，需要调用`缓冲输出流`的`flush()`方法，强制将缓冲区中已经缓存的数据写出文件，否则你会发现文件为空

```java
FileOutputStream fos = new FileOutputStream("bos.txt");
BufferedOutputStream bos = new BufferedOutputStream(fos);
// fos.write("我怀念的是我无话不说\n我怀念的是一起做梦".getBytes(StandardCharsets.UTF_8));
bos.write("我怀念的是我无话不说\n我怀念的是一起做梦".getBytes(StandardCharsets.UTF_8));
bos.flush();
// 在调用close()方法关闭缓冲输出流时，会自动调用1次flush方法，将所有byte数组中的内容写出
bos.close();
```

**总结：**`flush()`方法是被定义在`java.io.Flushable`接口中，而字节输出流的超类`java.io.OutputStream`实现了该接口，这意味着所有的字节输出流都有`flush()`方法

### 2.4 对象流（字节流）

1. **引入：**对象流是属于字节流和高级流，其主要分为**对象输入流**`ObjectInputStream`和**对象输出流**`ObjectOutputStream`

2. 因为硬盘的读写都是将数据转换成字节的形式后进行，所以需要**`对象流`**将`java`中的对象进行转换
   - **`对象输出流`**：将`java`对象进行序列化后，长期存储于硬盘中
   - **`对象输入流`**：将存储于硬盘中的`java`对象数据读取出来，进行反序列化后还原成`java`对象

#### 2.4.1 对象输出流

**序列化：**将对象转换为一组**`可被传输或保存`**的字节，这组字节中除了包含对象**`本身的数据`**外，还会包含**`结构信息`**

**规则：**对象输出流要求写出文件的对象必须实现`Serializable`接口，如果写出的对象所属的类没有实现`Serializable`接口时，会抛出未序列化异常`java.io.NotSerializableException`

**构造方法：**创建一个写出指定的`OutputStream`的`ObjectOutputStream`

```java
ObjectOutputStream(OutputStream out)
```

**常用方法：**将给定的对象转换为一组可保存或传输的字节然后通过其链接的流将字节写出

```java
void writeObject(Object obj)
```

#### 2.4.2 对象输入流

**反序列化：**将硬盘中读取的一组字节，通过其包含的结构信息和数据还原成对应的`java`对象

**构造方法：**创建从指定的`InputStream`读取的`ObjectInputStream`

```java
ObjectInputStream(InputStream in) 
```

**常用方法：**进行对象反序列化并返回，注意读取的字节必须是由ObjectOutputStream序列化一个对象所得到的字节

```java
Object readObject()
```

#### 2.4.3 对象流应用

```java
Person person = new Person("胡歌", 18, "男", new String[] {"帅气", "演技好", "谦逊有礼", "上海"});
FileOutputStream fos = new FileOutputStream("person.obj");
FileInputStream fis = new FileInputStream("person.obj");
ObjectOutputStream oos = new ObjectOutputStream(fos);
ObjectInputStream ois = new ObjectInputStream(fis);

oos.writeObject(person);
Person obj = (Person) (ois.readObject());
System.out.println(obj.toString());

ois.close();
oos.close();
```

#### 2.4.4 关键字transient

1. **引入：**当对象的属性被`transient`关键字修饰后，该对象在进行序列化时，转换出来的字节中是不包含该属性的

2. **作用：**使用`transient`关键字可以在对象持久化时减少磁盘开销，在进行传输时可以减少传输时间，如果该对象不需要序列化，那么该关键字`transient`不发挥其他任何效果
3. **注意事项：**如果一个对象在序列化时没有使用`transient`关键字修饰任何属性，但在进行反序列化时将某一个或者几个属性使用了`transient`修饰，在进行反序列化时会报无效类异常`InvalidClassException`，或者是在序列化时加了`transient`关键字，反序列化时没有加，也会报同样的异常

### 2.5 字符流与字节流

字符流是以字符(char)为单位读写数据的，一次处理一个unicode，字符流的底层仍然是由基本的字节流实现的

- `java.io.Reader`是输入流的父类，**`Writer`**的常用方法：

  > **`void write(int c)`：**写出一个字符，写出给定`int`值`低16`位表示的字符
  >
  > **`void write(char[] chs)`：**将给定字符数组`chs`中所有字符写出
  >
  > **`void write(String str)`：**将给定的字符串`str`写出
  >
  > **`void write(char[] chs, int offset, int length)`：**将给定的字符数组`chs`中从`offset`处开始连续的`length`个字符写出

- `java.io.Writer`是字符输出流的父类，**`Reader`**的常用方法：

  > **`int read()`：**读取一个字符，返回的`int`值`低16`位数字
  >
  > **`int read(char[] chs)`：**从该流中读取给定字符数组`chs`的`length`个字符并存入该数组，返回值为**`实际读取到的字符量`**

**字节流和字符流的区别：**

- `java`将流按照读写单位划分为`字节流`与`字符流`
- `java.io.InputStream`和`java.io.OutputStream`是所有字节流的超类
- 而`java.io.Reader`和``java.io.Writer`则是所有字符流的超类，它们和字节流的超类是**`平级`**关系
- `Reader`和`Writer`是两个抽象类，里面规定了所有字符流都必须具备的读写字符的相关方法
- **`字符流最小读写单位为字符(char)`**，但是底层实际还是读写字节，只是字符与字节的转换工作由字符流完成
- **`字符流都是高级流，字节流中除了文件流是低级流，其他的也都是高级流`**

### 2.6 转换流（字符流）

1. **引入：**`InputStreamReader`和`OutputStreamWriter`是常用的字符流的实现类，实际开发中我们不会直接操作转换流，但是在流连接中是必不可少的一环
2. **作用：**因为所有字符流都是高级流，所以需要链接在文件流上，这时就需要转换流在字符流和字节流之间做链接
   - 衔接字节流与其他字符流
   - 将字符与字节相互转换

3. **意义：**实际开发中我们还有功能更好用的字符高级流，但是其他的字符高级流都有一个共通点：不能直接连接在字节流上，而实际操作硬件设备的流都是低级流同时也都是字节流，因此不能直接在流的连接中串联起来，转换流是一对可以连接在字节流上的字符流，其他的高级字符流可以连接在转换流上，起到**`转换器`**的作用(负责字符与字节的实际转换)

#### 2.6.1 转换输出流

- **构造方法**

```java
// 基于给定的字节输出流以及字符编码创建OutputStreamWriter
OutputStreamWriter(OutputStream out, Charset cs)
    
// 该构造方法会根据系统默认字符集创建OutputStreamWriter
OutputStreamWriter(OutputStream out)
    
// 创建一个给定命名字符集的OutputStreamWriter
OutputStreamWriter(OutputStream out, String charsetName) 
```

- **常用方法**

```java
// 1.写出一个字符
void write(int c);

// 2.写出一个字符串的一部分
write(String str, int off, int len) 

// 3.写出字符数组的一部分
write(char[] cbuf, int off, int len) 

// 4.刷新流
void flush()
    
// 5.先刷新流，再关闭流
void close()
```

#### 2.6.2 转换输入流

- **构造方法**

```java
// 基于给定的字节输入流以及字符编码创建当前转换流
InputStreamWriter(InputStream in,Charset cs)
    
// 该构造方法会根据系统默认字符集创建当前转换流
InputStreamWriter(InputStream in)
    
// 创建一个使用命名字符集的InputStreamReader
InputStreamReader(InputStream in, String charsetName) 
```

- **常用方法**

```java
// 读取一个字符
int read()

// 关闭流并释放与之相关联的任何系统资源 
void close()
    
// 将字符读入数组的一部分
int read(char[] cbuf, int offset, int length) 
```

#### 2.6.3 转换流的应用

```java
FileOutputStream fos = new FileOutputStream("osw.txt");
OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

osw.write("我问为什么那女孩传简讯给我\n");
osw.write("而你为什么不解释低着头沉默");

// 转换输出流也有缓存区，需要手动flush将缓存区的数据写出或者调用close()间接调用flush方法
osw.close();

FileInputStream fis = new FileInputStream("osw.txt");
InputStreamReader isr = new InputStreamReader(fis);
int code;
while ((code = isr.read()) != -1) {
    System.out.print((char) code);
}
isr.close();
```

### 2.7 缓冲字符流

缓冲字符流包含`java.io.BufferedWriter`和`java.io.BufferedReader`，`缓冲字符流`内部也有一个缓冲区，读写文本数据以`块读写`形式加快效率，并且缓冲流有一个特别的功能：可以`按行读写`文本数据，缓冲流内部维护一个`char`数组，默认长度`8192`

#### 2.7.1 缓冲输出字符流

`java.io.PrintWriter`是具有**`自动行刷新`**的**`缓冲字符输出流`**，相比较于`java.io.BufferedWriter`，`java.io.PrintWriter`实际开发中更常用，它内部总是会自动链接在**`java.io.BufferedWriter`**作为块写加速使用

**特点：**

①可以按行写出字符串 

②具有自动行刷新功能：`PrintWriter`支持自动行刷新，每当我们调用`println()`方法写出一行内容后，可以自动调用一次`flush()`方法，不过这需要在调用构造方法时，添加第二个参数`boolean autoFlush`，如下面的第一个常用构造方法所示

**常用构造方法：**

```java
// 如果第二个参数为true则开启自动行刷新
PritWriter(Writer writer, boolean autoFlush)

PrintWriter(File file)
PrintWriter(String path)
    
// 还支持指定字符集
PrintWriter(File file, String csn)
PrintWriter(String path, String csn)  
    
// 上述构造器看似PW可以直接对文件进行操作，但是它是一个高级流，实际内部会进行流连接:
// this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))), false);
```

**其他构造方法：**

```java
// 将当前实例化的PrintWriter链接在指定的字符输出流上
PritWriter(Writer writer)    
    
// 将当前实例化的PrintWriter链接在指定的字节输出流上，构造方法内部会自行完成转换流等流连接
PrintWriter(OutputStream out)    

// 由于除了转换流外的其他字符流都不能直接连在字节流上，因此这个构造器内部会自动链接在BufferedWriter上
// BufferedWriter又链接在转换流OutputStreamWriter上，最后再让转换流链接在指定的字节输出流上
```

**常用方法：**

```java
// 写出数据后换行
void println(char/boolean/double/float/int/long/String/Object/char[] src)

// 写出数据后无操作
void print(char/boolean/double/float/int/long/String/Object/char[] src)
```

**示例：**

```java
// PrintWriter的字符
PrintWriter pw = new PrintWriter("pw.txt", "utf-8");
pw.print("你说爱像云");
pw.print("要自在飘浮才美丽");

// 输出流都需要手动关闭
pw.close();
```

#### 2.7.2 缓冲输入字符流

缓冲字符输入流`java.io.BufferedReader`内部维护一个默认`8192`长度的`char`数组，总是以**`块读取`**文本数据保证读取效率

**构造方法:**

```java
// 创建使用默认大小的输入缓冲区的缓冲字符输入流
BufferedReader(Reader in) 
  
// 创建使用指定大小的输入缓冲区的缓冲字符输入流 
BufferedReader(Reader in, int size) 
```

**常用方法：**

```java
// 返回一行字符串，方法内部会连续扫描若干个字符，直到遇到第一个换行符为止，将换行符之前的内容以一个字符串形式返回
String readLine()
// 返回值有三种情况:
// 1.正常的一行内容
// 2.空字符串，当读取了一个空行时(这一行只有一个换行符)
// 3.null，当读取到了末尾时
```

**注意事项：**

- 返回的字符串中不含有最后的换行符

- 当第一次调用`readLine()`方法时，缓冲输入字符流并不是只读取了第一行字符串，而是先进行**`块读取`**操作(一次性读取`8192`个字符并转入到内部缓冲区的`char`数组中)，然后扫描内部的`char`数组将第一行字符串返回，后面再次调用`readLine()`方法时则将第二行字符串返回，直到`8192`个字符被返回完后，才会去进行下一次的**`块读取`**操作

**示例：**

```java
FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.java");
InputStreamReader isr = new InputStreamReader(fis);
BufferedReader br = new BufferedReader(isr);

String code;
while ((code = br.readLine()) != null) {
    System.out.println(code);
}
br.close();
```

## 三、异常处理

- `java`中所有错误的超类为`Throwable`，其下有两个子类`Error`和`Exception`
- `Error`的派生类描述的都是系统错误，比如`虚拟机内存溢出`等
- `Exception`的派生类描述的都是程序错误，比如空指针`NullpointerException`、索引越界`OutOfBoundsException`等
- 通常我们程序中处理的异常都是`Exception`
-  `Java`异常可以分为**`可检测异常`**和**`非检测异常`**
  - **`可检测异常`**：可检测异常经编译器验证，对于声明抛出异常的任何方法，编译器将强制执行处理或声明规则，不捕捉这个异常，编译器就通不过，不允许编译
  - **`非检测异常`**：非检测异常不遵循处理或者声明规则，在产生此类异常时，编译器不会检查是否已经解决了这样一个异常
    - **`RuntimeException`**类是**`运行时异常`**，属于**`非检测异常`**，因为`JVM`操作引起的**`运行时异常`**随时可能发生，此类异常一般是由特定操作引发，但这些操作在`java`应用程序中会频繁出现，因此它们不受编译器检查与处理或声明规则的限制，实际上`RuntimeException`及其子类型表达的都是因为程序漏洞`BUG`，即逻辑不严谨等原因导致的，这类异常都是通过修复代码可完全避免的异常，因此不应当由异常处理机制来处理，而是由我们程序员修改代码来处理
    - **`异常处理机制`**关注的是明知道程序可能出现某种错误，但是该错误无法通过修改逻辑完全规避掉时，这时需要使用异常处理机制，在出现该错误是提供一种补救办法，使得代码能够正常运行

- 常见的`RuntimeException`子类
  - `IllegalArgumentException`：抛出的异常表明向方法传递了一个不合法或不正确的参数
  - `NullPointerException`：当应用程序试图在需要对象的地方使用 null 时，抛出该异常
  - `ArrayIndexOutOfBoundsException`：当使用的数组下标超出数组允许范围时，抛出该异常
  - `ClassCastException`：当试图将对象强制转换为不是实例的子类时，抛出该异常
  - `NumberFormatException`：当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常

### 3.1 try...catch...

**注意事项：**

- `try{}`语句块不能单独写，后面要么跟`catch{}`语句块要么跟`finally{}`语句块
- 当`try{}`中某句代码报错后，就会跳出`try{}`执行下面对应的`catch{}`块，执行后就会退出`catch{}`继续向后执行，因此`try{}`语句块中报错代码以下的内容都不会被执行
- 当`catch{}`捕获某个超类型异常时，那么`try{}`语句块中出现它类型异常时都可以被这个`catch{}`块捕获并处理
- 如果多个`catch{}`捕获的异常之间存在继承关系时，一定是派生类异常在上、超类异常在下，否则会编译不通过
- 当`try{}`语句块中可能出现的几种不同异常对应的处理办法相同时，可以采取合并`catch{}`的做法，用同一个`catch{}`来捕获这几种可能出现的异常，多个异常类型之间用 **`|`** 连接，而补救措施使用同一个

```java
/**
 * 语法:
 * try{
 *     可能出现异常的代码片段
 * }catch(XXXException e){
 *     出现异常后的处理措施代码片段
 * }
 */
```

### 3.2 finally {}

`finally{}`块是异常处理机制中的最后一块

- `finally{}`可以直接跟在`try{}`语句块之后
- `finally{}`可以跟在最后一个`catch{}`块之后
- `fianlly{}`下面不能再定义`catch{}`块
- 通常用来执行释放资源这一类操作，例如`I/O`操作完毕后的流关闭

**特点：**只要程序执行到异常处理机制中(执行到`try{}`语句块中)，无论`try{}`中的代码是否出现异常，`finally{}`中的语句最终都**必定执行**，哪怕是遇到`return`语句，`finally{}`中的语句都执行完才能结束方法

```java
public static void main(String[] args) {
    System.out.print(test("0") + ", " + test(null) + ", " + test(""));
    // 3, 3, 3
}

public static int test(String str) {
    try {
        return str.charAt(0) - '0';
    } catch (NullPointerException e) {
        return 1;
    } catch (Exception e) {
        return 2;
    } finally {
        return 3;
    }
}
```

### 3.3 自动关闭流

`JDK7`之后`java`推出了一个新特性：**`自动关闭特性`**可以更优雅地在异常处理机制中关闭`I/O`

**注意事项：**`try()`中可以声明的对象对应的类必须实现了`AutoCloseable`接口，字节流以及字符流的超类`OutputStream`、`Inputstream`、`Writer`以及`Reader`都实现了`AutoCloseable`接口

```java
/**
 * 语法:
 * try(
 * 	   声明并初始化I/O对象
 * ){
 *	   I/O操作
 * } catch(IOException e){// catch各种I/O异常
 *     ...
 * }
 */
```

**示例：**自动关闭特性只是简化了我们的代码编写，但在代码编译后简化的代码还是会变成和手动关闭`I/O`一样的代码

```java
public static void main(String[] args) {
    try (
        FileOutputStream fos = new FileOutputStream("./a.txt");
    ) {
        fos.write(128);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
/* 上面的代码在编译后会变成以下的代码 */
public static void main(String[] args) {
    FileOutputStream fos = null;
    try {
        fos = new FileOutputStream("./a.txt");
        fos.write(128);
    } catch (IOException e) {
        System.out.println("出错了!");
    } finally {
        try {
            if (fos != null) {
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 3.4 关键字

#### 3.4.1 throw

在编写程序时，我们必须要考虑程序出现问题的情况，比如在定义方法时，方法需要接收参数，当调用方法使用接收到的参数时，首先需要先对数据进行合法的判断，若数据不合法就应该告诉调用者传递合法的数据进来，这时需要使用抛出异常的方式来告诉调用者，在`java`中提供了一个`throw`关键字，它用来抛出一个指定类型的异常对象

**注意事项：**以下两种情况需要抛出异常

- 当程序遇到一个满足语法，但是不满足业务要求时，可以抛出一个异常告知调用者

- 程序执行遇到一个异常，但是该异常不应当在当前代码片段被解决时，可以抛出给调用者

#### 3.4.2 throws

`throws`方式处理异常又被称之为声明异常，将问题标识出来，报告给调用者，需要调用者去决定是**`解决异常`**还是继续将异常继续**`向上抛出`**，如果方法内通过`throw`抛出了编译时异常，而没有使用`try...catch...`捕获处理，那么必须通过`throws`进行声明，让调用者去处理，关键字`throws`运用于方法声明的参数列表之后，用于表示当前方法不处理异常

**注意事项：**若该方法可能有多种异常情况产生，那么在`throws`后面可以写多个异常类，异常之间用逗号隔开

```java 
spublic class Person {
    private int age;

    public int getAge() {
        return age;
    }

    // 使用throws关键字将异常抛出给方法的调用者
    public void setAge(int age) throws RuntimeException {
        // 当我们使用throw主动对外抛出一个异常时
        // 除了RuntimeException以外的其他异常都需要在方法上显式的声明throws来对外告知要抛出该异常
        if (age > 120 || age < 0) {
            throw new RuntimeException("年龄超出了范围!");
        }
        this.age = age;
    }
}
```

#### 3.4.3 两者的区别

- `throw`代表动作,表示抛出一个异常的动作；`throws`代表一种状态，代表方法可能有异常抛出
- `throw`用在方法实现中，而`throws`用在方法声明中
- `throw`只能用于抛出一种异常，而`throws`可以抛出多个异常

### 3.5 异常API

`Exception`上有一些常用的方法

- `void printStackTrace()`用于在控制台输出当前异常的堆栈跟踪信息

  便于程序员找到错误根源，分析错误原因制定`B计划`

- `String getMessage()`用于获取当前错误消息

  多用于提示给用户或记录日志使用

### 3.6 自定义异常

当系统的提供的异常不足以清晰地表达业务中遇到的异常，比如说：年龄超出范围，这时我们就需要自定义异常，以达到让人看见异常名就知道定义自定义异常需要注意以下问题:

- 异常的类名要做到见名知义
- 需要是Exception的子类
- 提供超类异常提供的所有种类构造器

