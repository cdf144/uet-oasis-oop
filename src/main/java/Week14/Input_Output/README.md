### Đề bài :

Java cung cấp sự hỗ trợ mạnh mẽ cho các thao tác I/O liên quan tới các File (đọc, ghi,…). Ví dụ với đọc 1 file text, Java cung cấp nhiều cách khác nhau. Có thể sử dụng FileReader như dưới đây.

```java
BufferedReader in = new BufferedReader(new FileReader("c:\filename.txt"));
String str;
while ((str = in.readLine()) != null) {
    System.out.println(str);
}
```

Hoặc có thể sử dụng File.ReadAllLines() như dưới đây. Phương thức này sẽ trả về 1 List các String tương ứng với các dòng của file text.

```java
List<String> lines = Files.readAllLines(Paths.get("C:\filename.txt"));
```

**Yêu cầu:** Dựa trên hướng dẫn phía trên, hãy xây dựng lớp tiện ích Utils, sử dụng code mẫu tại: https://github.com/oasis-homework/BaiTapHangTuan/tree/main/week9

a. Viết phương thức static để đọc một tệp .txt từ ổ cứng:

```java
public static String readContentFromFile(String path)
```

Trong đó biến path là đường dẫn đến tệp cần đọc, lưu ý cả trường hợp đường dẫn tương đối và tuyệt đôi, quản lý file trên hệ điều hành Linux cũng như Windows

b. Viết phương thức static để xuất nội dung một xâu vào 1 tệp trong ổ cứng:

```java
public static void writeContentToFile(String path)
```

trong đó biến path là đường dẫn đến tệp cần ghi nội dung. Nếu tệp đã có nội dung thì ta xóa nội dung đó trước khi ghi nội dung mới.

c. Tương tự ý câu b nhưng thay vì xóa nội dung cũ đi, ta bổ sung nội dung mới vào cuối tệp hiện tại

d. Viết phương thức static để tìm kiếm một tệp trong một thư mục:

```java
public static File findFileByName(String folderPath, String fileName),
```

trong đó folderPath là tên thư mục, fileName là tên tệp cần tìm kiếm.

### Source code mẫu :

https://github.com/oasis-homework/BaiTapHangTuan/tree/main/week9

### Điều kiện :

None