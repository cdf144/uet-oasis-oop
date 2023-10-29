### Đề bài :

Tạo lớp **Solution** có hai thuộc tính là tử (numerator) và mẫu (denominator)

a. Khai báo hai thuộc tính **numerator** và **denominator** có kiểu là int, mức truy nhập đều là `private`

b. Viết các phương thức getter, setter cho các thuộc tính

c. Viết phương thức khởi tạo có tham số cho lớp Solution có sử dụng từ khóa this

d. Viết phương thức rút gọn (**reduce**) phân số. Gợi ý sử dụng phương thức tìm ước số chung lớn nhất. Lưu ý phương thức trả về đối tượng phân số hiện tại.

e. Xây dựng các phương thức cộng (**add**), trừ (**subtract**), nhân (**multiply**), chia (**divide**) phân số với tham số là một phân số khác, kết quả tính toán sẽ được ghi vào phân số hiện tại. Lưu ý các phương thức này trả về đối tượng phân số hiện tại.

f. Viết phương thức “**public boolean equals(Object obj)**” so sánh hai phân số. Nếu **obj** không phải là kiểu **Solution** thì trả về **false**. Ngược lại trả về **true** khi 2 phân số bằng nhau, còn lại là **false**. Gợi ý sử dụng `instanceof` để kiểm tra **obj** có phải kiểu **Solution**, sau đó ép kiểu trước khi so sánh.

```java
if (obj instanceof Solution) {

    Solution other = (Solution) obj;
    
    // compare this vs other here

}
```

_Lưu ý phải luôn đảm bảo phân số là hợp lệ trong mọi trường hợp:_

- Giá trị khởi tạo mặc định của mẫu số khi khai báo là 1
- Không cho phép khởi tạo phân số có mẫu số bằng 0, hoặc set giá trị mẫu số bằng 0, hoặc thực hiện phép chia cho phân số 0
- Trong những trường hợp không cho phép đó, bạn không cần in hoặc ném ra lỗi, chỉ cần khôi phục lại các giá trị trước đó của phân số