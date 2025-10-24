package com.example.servingwebcontent.Exception;

// Class ngoại lệ tự định nghĩa kế thừa từ Exception
public class MyException extends Exception {

    // Constructor nhận thông báo lỗi
    public MyException(String message) {
        super(message);  // Gọi constructor của lớp cha (Exception)
    }
    
    // (Tuỳ chọn) có thể thêm constructor thứ 2 nhận cả nguyên nhân gốc (Throwable)
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
