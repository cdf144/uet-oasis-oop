### Đề bài :

[Java Collection Framework](https://docs.oracle.com/javase/tutorial/collections/index.html) gồm những lớp thư viện Java giúp bạn lập trình dễ dàng và nhanh gọn hơn. Dưới đây giới thiệu sơ qua **List** và **String**, bạn tự tìm hiểu các lớp khác ở link trên.

- **List**

List Interface là một loại Interface Collection. Các phần tử của List Interface được sắp xếp có thứ tự và giá trị của các phần tử này có thể trùng nhau. Các phần tử trong List có thể được truy cập, thêm, sửa hoặc xóa thông qua vị trí của nó trong danh sách, và phần tử đầu tiên trong List sẽ có chỉ số là 0. Chi tiết về các phương thức của List có thể xem tại đây: https://docs.oracle.com/javase/8/docs/api/java/util/List.html

```java
List<String> list =new ArrayList<String>();
list.add("An");
list.add("Nguyen");
list.add("Tung");
System.out.println(list.get(2)); // Tung
list.add(1,"Binh");
System.out.println(list.get(2)); // Nguyen
```

- **String**

Chuỗi (String) trong Java cung cấp nhiều khái niệm đa dạng giúp ta thao tác và xử lý với chuỗi như so sánh, cắt, nối, tìm độ dài, thay thế, tìm chuỗi con,…. Trong Java, về cơ bản chuỗi là một đối tượng mà biểu diễn dãy các giá trị char. Chuỗi (String) trong Java là không thể thay đổi (immutable), ví dụ: nó không thể bị thay đổi nhưng sẽ có một instance được tạo. Tuy nhiên, nếu muốn sử dụng các lớp mà có thể thay đổi, có thể lựa chọn sử dụng các lớp StringBuffer và StringBuilder. Chi tiết về các phương thức của String có thể xem tại đây: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html

```java
String a = new String("abc");
String b = "abc";
System.out.println(a == b); // false
System.out.println(a.equals(b)); // true
System.out.println(a.length()); // 3
System.out.println(a + b); // abcabc
a = " demo_trim ";

System.out.println("before trim:" + a + "!"); 
// before trim: demo_trim !

System.out.println("after trim:" + a.trim() + "!"); 
// after trim:demo_trim!
```

Yêu cầu:

Trong bài tập này, bạn sẽ được làm quen với công việc cơ bản của hướng nghiên cứu [Phân tích chương trình](https://en.wikipedia.org/wiki/Static_program_analysis). Đây là một bài tập khó và tiêu tốn thời gian, vì thế bạn cần thật kiên nhẫn khi làm bài tập này.

Đề bài: Áp dụng các phép biến đổi xâu, các cấu trúc dữ liệu của Java Collection Framework, hãy tạo lớp có tên **Week10** và cài đặt phương thức _List\<String\> getAllFunctions(String fileContent)_ để lấy toàn bộ chữ ký các phương thức `static` (method signature) trong một tệp cho trước qua các phép xử lý xâu, trong đó _fileContent_ là nội dung tệp bạn cần xử lý. Mỗi một phần tử String trong đối tượng trả về lưu mã nguồn phương thức static tìm được.

Định dạng chữ ký phương thức được quy định theo định dạng:

```
methodName(parameter1_type,parameter2_type,...)
```

Chú ý là parameter1_type, parameter2_type,... phải là [Fully Qualified Type Name](https://en.wikipedia.org/wiki/Fully_qualified_name)

Dưới đây là một số ví dụ:

```
public static void sayHello() {}
=> sayHello()
---------------------------------------------
public static int add(int a, int b) {}
=> add(int,int)
---------------------------------------------
public static void printMessage(String message) {}
=> printMessage(java.lang.String)
---------------------------------------------
public static void printMessages(String[] messages) {}
=> printMessages(java.lang.String[])
---------------------------------------------
import java.io.File;
public static String readFile(File file) {}
=> readFile(java.io.File)
---------------------------------------------
// tệp này có 2 lớp
package net.bqc.utils;
class Message {}
public static void printMessage(Message message) {}
=> printMessage(net.bqc.utils.Message)
---------------------------------------------
// tệp này có 2 lớp
package net.bqc.utils;
import java.util.List;
class Message {}
public static void printMessages(List<Message> messages) {}
=> printMessages(java.util.List<net.bqc.utils.Message>)
```

Tập dữ liệu được sử dụng để làm testcase được lấy từ hai repository dưới đây (đã chỉnh sửa):

- https://github.com/Nordstrom/Java-Utils
- https://github.com/RKumsher/utils

Dưới đây là một số Expected Output cho một số trường hợp trích xuất từ hai repository ở trên:

```
// VolumeInfo.java
[getVolumeProps(), getVolumeProps(java.io.InputStream)]
---------------------------------------------
// RandomNumberUtils.java
[randomInt(), randomInt(int,int), randomIntLessThan(int), randomLong(), randomPositiveLong(), randomNegativeLong(), randomLong(long,long), randomLongGreaterThan(long), randomLongLessThan(long), randomDouble(), randomPositiveDouble(), randomNegativeDouble(), randomDouble(double,double), randomDoubleGreaterThan(double), randomDoubleLessThan(double)]
---------------------------------------------
// DatabaseUtils.java
[update(com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), getInt(com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), getString(com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), getResultPackage(com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), executeQuery(java.lang.Class<?>,com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), executeQuery(java.lang.Class<?>,java.lang.String,java.lang.String,java.lang.Object), getInt(com.nordstrom.common.jdbc.utils.SProcAPI,java.lang.Object), getString(com.nordstrom.common.jdbc.utils.SProcAPI,java.lang.Object), getResultPackage(com.nordstrom.common.jdbc.utils.SProcAPI,java.lang.Object), executeStoredProcedure(java.lang.Class<?>,com.nordstrom.common.jdbc.utils.SProcAPI,java.lang.Object), executeStoredProcedure(java.lang.Class<?>,java.lang.String,java.lang.String,com.nordstrom.common.jdbc.Param), executeStatement(java.lang.Class<?>,java.sql.Connection,java.sql.PreparedStatement), getConnection(java.lang.String)]
```

_Chú ý trường hợp phương thức đặt trong comment._

### Định dạng đầu vào :

1. Các file .java nộp lên **không định danh package** trong đó (bỏ tất cả dòng pakage)
2. Tất cả **file .java** đặt **cùng trong một folder** và được nén lại dưới đuôi .zip
3. **Tên folder** chứa các **file .java** không được chứa ký tự đặc biệt hoặc ký tự khoảng trắng.

### Source code mẫu :

https://github.com/oasis-homework/BaiTapHangTuan/blob/main/Week10.java

### Điều kiện :

None