### Đề bài :

Định nghĩa lớp giao dịch **Transaction**:

- Thêm các thuộc tính với mức truy nhập **private** gồm :
    - Thuộc tính tên loại giao dịch `operation` có kiểu là `String`
    - Thuộc tính số tiền giao dịch `amount` có kiểu là `double`
    - Thuộc tính số dư còn lại trong tài khoản `balance` có kiểu là `double`
- Khai báo hai biến hằng có sử dụng `static` ,`final`: DEPOSIT, WITHDRAW đều có kiểu là `String` và mức truy nhập là **public**.
- Thêm phương thức khởi tạo có ba tham số (operation, amount, balance)
- Thêm phương thức **getter/setter** cho các thuộc tính.

Định nghĩa lớp **Account**:

- Thêm các thuộc tính với mức truy nhập **private** gồm:
    - Thuộc tính thông tin về số dư tài khoản ngân hàng `balance`, có kiểu là `double`
    - Một _danh sách các giao dịch_ (sử dụng `ArrayList`) để theo dõi các thao tác nạp tiền, rút tiền (vì lịch sử giao dịch chỉ được sử dụng ở phương thức `printTransaction()`). 
- Thêm hai phương thức _deposit, withdraw_ với mức truy nhập **private** (vì hai phương thức này sẽ được gọi và sử dụng qua phương thức **public** `addTransaction`):
- Tạo phương thức **deposit** có một tham số để nạp tiền vào tài khoản, có kiểu trả về `void` và có tham số truyền vào là số tiền giao dịch `amount` (có kiểu `double`).
    - Số tiền nạp vào phải lớn hơn 0, ngược lại in ra xuất chuẩn: `So tien ban nap vao khong hop le!`
- Tương tự như deposit ta tạo phương thức **withdraw** có một tham số để rút tiền từ tài khoản, có kiểu trả về `void` và có tham số truyền vào là số tiền giao dịch `amount` (có kiểu `double`).
    - Số tiền rút ra phải lớn hơn 0, ngược lại in ra xuất chuẩn `So tien ban rut ra khong hop le!`
    - Nếu số tiền rút lớn hơn số dư, in ra xuất chuẩn `So tien ban rut vuot qua so du!`
- Thêm phương thức **addTransaction** để thêm một giao dịch vào danh sách các giao dịch:
    - Có kiểu trả về `void`
    - Có hai tham số truyền vào là:
        - `amount` - số tiền giao dịch (kiểu `double`)
        - `operation` - tên loại giao dịch (kiểu `String`, có hai loại giao dịch DEPOSIT, WITHDRAW đã được định nghĩa trong **Transaction**).
    - Nếu loại giao dịch truyền vào `operation` khác hai loại đã được định nghĩa, in ra xuất chuẩn: `Yeu cau khong hop le!`
- Tạo phương thức không có tham số **printTransaction()** để đưa ra các dòng xuất chuẩn thông tin về tất cả các giao dịch của mỗi tài khoản, có kiểu trả về `void`, mức truy nhập **public**. Số tiền in ra được **làm tròn hai chữ số thập phân sau dấu phẩy**. Ví dụ: 

    ```java
    Account acc = new Account();  
    acc.addTransaction(2000.255,"deposit");  
    acc.addTransaction(1000,"withdraw");  
    acc.printTransaction();
    ```

    Kết quả trả ra:
    
    ```
    Giao dich 1: Nap tien $2000.26. So du luc nay: $2000.26.
    Giao dich 2: Rut tien $1000.00. So du luc nay: $1000.26.
    ```

### Định dạng đầu vào :

1. Các file .java nộp lên **không định danh package** trong đó (bỏ tất cả dòng pakage)
2. Tất cả **file .java** đặt **cùng trong một folder** và được nén lại dưới đuôi .zip
3. **Tên folder** chứa các **file .java** không được chứa ký tự đặc biệt hoặc ký tự khoảng trắng.

### Định dạng đầu ra :

None

### Source code mẫu :

None

### Điều kiện :

None